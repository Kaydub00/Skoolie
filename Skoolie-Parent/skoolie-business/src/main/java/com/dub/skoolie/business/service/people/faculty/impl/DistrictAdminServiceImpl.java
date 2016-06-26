/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.people.faculty.impl;

import com.dub.skoolie.business.service.people.faculty.DistrictAdminService;
import com.dub.skoolie.data.dao.people.faculty.DistrictAdminRepository;
import com.dub.skoolie.data.entities.people.faculty.DistrictAdmin;
import com.dub.skoolie.structures.people.faculty.DistrictAdminBean;
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
public class DistrictAdminServiceImpl implements DistrictAdminService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    DistrictAdminRepository repo;

    @Override
    public DistrictAdminBean updateEntity(DistrictAdminBean entity) {
        DistrictAdmin da = new  DistrictAdmin();
        mapper.map(entity, da);
        da = repo.save(da);
        mapper.map(da,entity);
        return entity;
    }

    @Override
    public void deleteEntity(DistrictAdminBean entity) {
        this.deleteByID(entity.getUsername());
    }

    @Override
    public void deleteByID(String id) {
        repo.delete(id);
    }

    @Override
    public DistrictAdminBean getByID(String id) {
        DistrictAdminBean dab = new DistrictAdminBean();
        try {
            mapper.map(repo.findOne(id), dab);
        } catch (MappingException e) {
            // need to log this
            return null;
        }
        return dab;
    }

    @Override
    public List<DistrictAdminBean> getAll() {
        List<DistrictAdminBean> newlist = new ArrayList<>();
        Iterable<DistrictAdmin> list = repo.findAll();
        for(DistrictAdmin da : list) {
            newlist.add(mapper.map(da, DistrictAdminBean.class));
        }
        return newlist;
    }
    
}
