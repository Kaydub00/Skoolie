
package com.dub.skoolie.business.service.usr.security.impl;

import com.dub.skoolie.business.service.usr.security.UserRoleService;
import com.dub.skoolie.data.dao.usr.security.UserRoleRepository;
import com.dub.skoolie.data.entities.usr.security.UserRole;
import com.dub.skoolie.structures.usr.security.UserRoleBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kevin W.
 */
@Transactional("skooliecoreTransactionManager")
@Service
public class UserRoleServiceImpl implements UserRoleService {
    
    @Autowired
    DozerBeanMapper mapper;
    
    @Autowired
    UserRoleRepository repo;

    @Override
    public void updateEntity(UserRoleBean entity) {
        UserRole usrrole = new UserRole();
        mapper.map(entity, usrrole);
        repo.save(usrrole);
    }

    @Override
    public void deleteEntity(UserRoleBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public UserRoleBean getByID(Long id) {
        UserRoleBean usrrole = new UserRoleBean();
        mapper.map(repo.findOne(id),  usrrole);
        return usrrole;
    }

    @Override
    public List<UserRoleBean> getAll() {
        List<UserRoleBean> list = new ArrayList();
        mapper.map(repo.findAll(), list);
        return list;
    }

}
