/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.school.impl;

import com.dub.skoolie.business.service.school.SchoolRoomService;
import com.dub.skoolie.data.dao.school.SchoolRoomRepository;
import com.dub.skoolie.data.entities.school.SchoolRoom;
import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.structures.school.SchoolRoomBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kevin W
 */
@Transactional("skooliecoreTransactionManager")
@Service
public class SchoolRoomServiceImpl implements SchoolRoomService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    SchoolRoomRepository repo;

    @Override
    public SchoolRoomBean updateEntity(SchoolRoomBean entity) {
        SchoolRoom rm = new  SchoolRoom();
        mapper.map(entity, rm);
        rm = repo.save(rm);
        mapper.map(rm,entity);
        return entity;
    }

    @Override
    public void deleteEntity(SchoolRoomBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public SchoolRoomBean getByID(Long id) {
        SchoolRoomBean rm = new SchoolRoomBean();
        mapper.map(repo.findOne(id), rm);
        return rm;
    }

    @Override
    public List<SchoolRoomBean> getAll() {
        List<SchoolRoomBean> newlist = new ArrayList<>();
        Iterable<SchoolRoom> list = repo.findAll();
        for(SchoolRoom rm : list) {
            newlist.add(mapper.map(rm, SchoolRoomBean.class));
        }
        return newlist;
    }

    @Override
    public List<SchoolRoomBean> getSchoolRoomsBySchoolId(Long id) {
        List<SchoolRoomBean> newlist = new ArrayList<>();
        Iterable<SchoolRoom> list = repo.findSchoolRoomsBySchoolId(id);
        for(SchoolRoom rm : list) {
            newlist.add(mapper.map(rm, SchoolRoomBean.class));
        }
        return newlist;
    }

    @Override
    public List<SchoolRoomBean> getSchoolRoomsBySchool(SchoolBean school) {
        List<SchoolRoomBean> newlist = new ArrayList<>();
        Iterable<SchoolRoom> list = repo.findSchoolRoomsBySchoolId(school.getId());
        for(SchoolRoom rm : list) {
            newlist.add(mapper.map(rm, SchoolRoomBean.class));
        }
        return newlist;
    }
    
}
