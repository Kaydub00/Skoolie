
package com.dub.skoolie.business.service.usr.security.impl;

import com.dub.skoolie.business.service.usr.security.GroupService;
import com.dub.skoolie.business.service.usr.security.UserService;
import com.dub.skoolie.data.dao.usr.security.UserRepository;
import com.dub.skoolie.data.entities.usr.security.User;
import com.dub.skoolie.structures.usr.security.UserBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kevin W.
 */
@Transactional("skooliecoreTransactionManager")
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    UserRepository repo;
    
    @Autowired
    GroupService groupServiceImpl;
    
    @Override
    public UserBean updateEntity(UserBean entity) {
        User user = new User();
        if(entity.getPassword() == null || entity.getPassword().isEmpty()) {
            User origuser = new User();
            origuser = repo.findOne(entity.getUsername());
            entity.setPassword(origuser.getPassword());
            mapper.map(entity, user);
            user = repo.save(user);
            mapper.map(user, entity);
            return entity;
        } else {
            mapper.map(entity, user);
            user = repo.save(user);
            mapper.map(user, entity);
            return entity;
        }
    }
    
    @Override
    public void deleteEntity(UserBean entity) {
        this.deleteByID(entity.getUsername());
    }

    @Override
    public void deleteByID(String id) {
        repo.delete(id);
    }

    @Override
    public UserBean getByID(String id) {
        UserBean usr = new UserBean();
        mapper.map(repo.findOne(id), usr);
        return usr;
    }

    @Override
    public List<UserBean> getAll() {
        List<UserBean> newlist = new ArrayList<>();
        Iterable<User> list = repo.findAll();
        for(User user : list) {
            newlist.add(mapper.map(user, UserBean.class));
        }
        return newlist;
    }

    @Override
    public void addUser(UserBean user) {
        User entity = new User();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encpwd = encoder.encode(user.getPassword());
        user.setPassword(encpwd);
        if(user.getType().equals("STUDENT")) {
            user.addGroup(groupServiceImpl.getByID("GRP_STUDENT"));
            user.addGroup(groupServiceImpl.getByID("GRP_USER"));
        } else if (user.getType().equals("PARENT")) {
            user.addGroup(groupServiceImpl.getByID("GRP_PARENT"));
            user.addGroup(groupServiceImpl.getByID("GRP_USER"));
        } else if (user.getType().equals("TEACHER")) {
            user.addGroup(groupServiceImpl.getByID("GRP_TEACHER"));
            user.addGroup(groupServiceImpl.getByID("GRP_USER"));
        } else if (user.getType().equals("SCHOOL_ADMIN")) {
            user.addGroup(groupServiceImpl.getByID("GRP_SCHOOL_ADMIN"));
            user.addGroup(groupServiceImpl.getByID("GRP_USER"));
            user.addGroup(groupServiceImpl.getByID("GRP_ADMIN"));
        } else if (user.getType().equals("DISTRICT_ADMIN")) {
            user.addGroup(groupServiceImpl.getByID("GRP_DISTRICT_ADMIN"));
            user.addGroup(groupServiceImpl.getByID("GRP_USER"));
            user.addGroup(groupServiceImpl.getByID("GRP_ADMIN"));
        } else if (user.getType().equals("SYSTEM")) {
            user.addGroup(groupServiceImpl.getByID("GRP_ADMIN"));
        }
        mapper.map(user, entity);
        repo.save(entity);
    }
    
    @Override
    public void enableUser(String username) {
        User entity = new User();
        UserBean bean = this.getByID(username);
        bean.setEnabled(1);
        mapper.map(bean, entity);
        repo.save(entity);
    }
    
    @Override
    public void deactivateUser(String username) {
        User entity = new User();
        UserBean bean = this.getByID(username);
        bean.setEnabled(0);
        mapper.map(bean, entity);
        repo.save(entity);
    }

    @Override
    public void resetUserPassword(String username, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encpwd = encoder.encode(password);
        User entity = repo.findOne(username);
        entity.setPassword(encpwd);
        repo.save(entity);
    }
    
    

}
