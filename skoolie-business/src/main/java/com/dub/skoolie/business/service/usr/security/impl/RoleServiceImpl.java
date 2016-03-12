
package com.dub.skoolie.business.service.usr.security.impl;

import com.dub.skoolie.business.service.usr.security.RoleService;
import com.dub.skoolie.data.dao.usr.security.RoleRepository;
import com.dub.skoolie.structures.usr.security.RoleBean;
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
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    RoleRepository repo;
    
    @Autowired
    DozerBeanMapper mapper;

    @Override
    public List<RoleBean> getAllRoles() {
        List<RoleBean> list = new ArrayList();
        mapper.map(repo.findAll(), list);
        return list;
    }

    @Override
    public RoleBean getRole(String id) {
        RoleBean bean = new RoleBean();
        mapper.map(repo.findOne(id), bean);
        return bean;
    }

}
