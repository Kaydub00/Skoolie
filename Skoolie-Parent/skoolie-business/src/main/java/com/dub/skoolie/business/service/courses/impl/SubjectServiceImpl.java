/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.courses.impl;

import com.dub.skoolie.business.service.courses.SubjectService;
import com.dub.skoolie.data.dao.courses.SubjectRepository;
import com.dub.skoolie.data.entities.courses.Subject;
import com.dub.skoolie.structures.courses.SubjectBean;
import com.dub.skoolie.structures.school.SchoolBean;
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
public class SubjectServiceImpl implements SubjectService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    SubjectRepository repo;

    @Override
    public List<SubjectBean> getSubjectsBySchool(SchoolBean school) {
        List<SubjectBean> newlist = new ArrayList<>();
        Iterable<Subject> list = repo.findSubjectBySchoolId(school.getId());
        for(Subject sbj : list) {
            newlist.add(mapper.map(sbj, SubjectBean.class));
        }
        return newlist;
    }

    @Override
    public List<SubjectBean> getSubjectsBySchoolId(Long id) {
        List<SubjectBean> newlist = new ArrayList<>();
        Iterable<Subject> list = repo.findSubjectBySchoolId(id);
        for(Subject sbj : list) {
            newlist.add(mapper.map(sbj, SubjectBean.class));
        }
        return newlist;
    }

    @Override
    public SubjectBean updateEntity(SubjectBean entity) {
        Subject sbj = new Subject();
        mapper.map(entity, sbj);
        sbj = repo.save(sbj);
        mapper.map(sbj,entity);
        return entity;
    }

    @Override
    public void deleteEntity(SubjectBean entity) {
        repo.delete(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public SubjectBean getByID(Long id) {
        SubjectBean sbj = new SubjectBean();
        mapper.map(repo.findOne(id), sbj);
        return sbj;
    }

    @Override
    public List<SubjectBean> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
