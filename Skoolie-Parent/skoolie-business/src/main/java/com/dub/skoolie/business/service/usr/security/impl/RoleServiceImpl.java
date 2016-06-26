
package com.dub.skoolie.business.service.usr.security.impl;

import com.dub.skoolie.business.service.usr.security.RoleService;
import com.dub.skoolie.data.dao.usr.security.RoleRepository;
import com.dub.skoolie.data.entities.usr.security.Role;
import com.dub.skoolie.structures.usr.security.RoleBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kevin W.
 */
@Transactional("skooliecoreTransactionManager")
@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    RoleRepository repo;
    
    @Autowired
    Mapper mapper;

    @Override
    public List<RoleBean> getAllRoles() {
        List<RoleBean> newlist = new ArrayList<>();
        Iterable<Role> list = repo.findAll();
        for(Role role : list) {
            newlist.add(mapper.map(role, RoleBean.class));
        }
        return newlist;
    }

    @Override
    public RoleBean getRole(String id) {
        RoleBean bean = new RoleBean();
        mapper.map(repo.findOne(id), bean);
        return bean;
    }

}
