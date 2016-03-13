
package com.dub.skoolie.business.service.usr.security.impl;

import com.dub.skoolie.business.service.usr.security.UserService;
import com.dub.skoolie.data.dao.usr.security.UserRepository;
import com.dub.skoolie.data.entities.usr.security.User;
import com.dub.skoolie.structures.usr.security.RoleBean;
import com.dub.skoolie.structures.usr.security.UserBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
    DozerBeanMapper mapper;
    
    @Autowired
    UserRepository repo;
    
    
    @Override
    //@Secured("ROLE_USER")
    public void updateEntity(UserBean entity) {
        User user = new User();
        if(entity.getPassword() == null || entity.getPassword().isEmpty()) {
            User origuser = new User();
            origuser = repo.findOne(entity.getUsername());
            entity.setPassword(origuser.getPassword());
            mapper.map(entity, user);
            repo.save(user);
        } else {
            mapper.map(entity, user);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encpwd = encoder.encode(user.getPassword());
            user.setPassword(encpwd);
            repo.save(user);
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
        List<UserBean> list = new ArrayList();
        mapper.map(repo.findAll(), list);
        return list;
    }

    @Override
    public void addUser(UserBean user) {
        User entity = new User();
        RoleBean role = new RoleBean();
        role.setRole("ROLE_USER");
        user.addRole(role);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encpwd = encoder.encode(user.getPassword());
        user.setPassword(encpwd);
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

}
