/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.people.parents.impl;

import com.dub.skoolie.business.service.people.parents.ParentService;
import com.dub.skoolie.data.dao.people.parents.ParentRepository;
import com.dub.skoolie.data.entities.people.parents.Parent;
import com.dub.skoolie.structures.people.parents.ParentBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kevin W
 */
@Transactional("skooliecoreTransactionManager")
@Service
public class ParentServiceImpl implements ParentService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    ParentRepository repo;

    @Override
    public ParentBean updateEntity(ParentBean entity) {
        Parent p = new  Parent();
        mapper.map(entity, p);
        p = repo.save(p);
        mapper.map(p,entity);
        return entity;
    }

    @Override
    public void deleteEntity(ParentBean entity) {
        this.deleteByID(entity.getUsername());
    }

    @Override
    public void deleteByID(String id) {
        repo.delete(id);
    }

    @Override
    public ParentBean getByID(String id) {
        ParentBean p = new ParentBean();
        try {
            mapper.map(repo.findOne(id), p);
        } catch(MappingException e) {
            //need to log this
            return null;
        }
        return p;
    }

    @Override
    public List<ParentBean> getAll() {
        List<ParentBean> newlist = new ArrayList<>();
        Iterable<Parent> list = repo.findAll();
        for(Parent p : list) {
            newlist.add(mapper.map(p, ParentBean.class));
        }
        return newlist;
    }
    
}
