/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.people.faculty.impl;

import com.dub.skoolie.business.service.people.faculty.SchoolAdminService;
import com.dub.skoolie.data.dao.people.faculty.SchoolAdminRepository;
import com.dub.skoolie.data.entities.people.faculty.SchoolAdmin;
import com.dub.skoolie.structures.people.faculty.SchoolAdminBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class SchoolAdminServiceImpl implements SchoolAdminService {
    
    @Autowired
    DozerBeanMapper mapper;
    
    @Autowired
    SchoolAdminRepository repo;

    @Override
    public SchoolAdminBean updateEntity(SchoolAdminBean entity) {
        SchoolAdmin sa = new  SchoolAdmin();
        mapper.map(entity, sa);
        sa = repo.save(sa);
        mapper.map(sa,entity);
        return entity;
    }

    @Override
    public void deleteEntity(SchoolAdminBean entity) {
        this.deleteByID(entity.getUsername());
    }

    @Override
    public void deleteByID(String id) {
        repo.delete(id);
    }

    @Override
    public SchoolAdminBean getByID(String id) {
        SchoolAdminBean sab = new SchoolAdminBean();
        try {
            mapper.map(repo.findOne(id), sab);
        } catch(MappingException e){
            //need to log this
            return null;
        }
        return sab;
    }

    @Override
    public List<SchoolAdminBean> getAll() {
        List<SchoolAdminBean> newlist = new ArrayList<>();
        Iterable<SchoolAdmin> list = repo.findAll();
        for(SchoolAdmin sa : list) {
            newlist.add(mapper.map(sa, SchoolAdminBean.class));
        }
        return newlist;
    }
    
}
