/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.usr.security.impl;

import com.dub.skoolie.business.service.usr.security.UserTypeService;
import com.dub.skoolie.data.dao.usr.security.UserTypeRepository;
import com.dub.skoolie.data.entities.usr.security.UserType;
import com.dub.skoolie.structures.usr.security.UserTypeBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kevin W
 */
@Transactional("skooliecoreTransactionManager")
@Service
public class UserTypeServiceImpl implements UserTypeService {
    
    @Autowired
    DozerBeanMapper mapper;
    
    @Autowired
    UserTypeRepository repo;
    
    @Override
    public List<UserTypeBean> getAll() {
        List<UserTypeBean> newlist = new ArrayList();
        Iterable<UserType> list = repo.findAll();
        for(UserType type : list) {
            newlist.add(mapper.map(type, UserTypeBean.class));
        }
        return newlist;
    }

    @Override
    public void updateEntity(UserTypeBean entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEntity(UserTypeBean entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserTypeBean getByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
