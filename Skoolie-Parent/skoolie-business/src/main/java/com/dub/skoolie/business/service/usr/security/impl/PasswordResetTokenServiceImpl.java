/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.usr.security.impl;

import com.dub.skoolie.business.service.usr.security.PasswordResetTokenService;
import com.dub.skoolie.data.dao.usr.security.PasswordResetTokenRepository;
import com.dub.skoolie.data.entities.usr.security.PasswordResetToken;
import com.dub.skoolie.structures.usr.security.PasswordResetTokenBean;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kevinw
 */
@Transactional("skooliecoreTransactionManager")
@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    PasswordResetTokenRepository repo;

    @Override
    public PasswordResetTokenBean updateEntity(PasswordResetTokenBean entity) {
        PasswordResetToken tkn = new  PasswordResetToken();
        mapper.map(entity, tkn);
        tkn = repo.save(tkn);
        mapper.map(tkn,entity);
        return entity;
    }

    @Override
    public void deleteEntity(PasswordResetTokenBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public PasswordResetTokenBean getByID(Long id) {
        PasswordResetTokenBean tkn = new PasswordResetTokenBean();
        mapper.map(repo.findOne(id), tkn);
        return tkn;
    }

    @Override
    public List<PasswordResetTokenBean> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
