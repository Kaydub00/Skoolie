/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.district.impl;

import com.dub.skoolie.business.service.district.DistrictService;
import com.dub.skoolie.data.dao.district.DistrictRepository;
import com.dub.skoolie.data.entities.district.District;
import com.dub.skoolie.structures.district.DistrictBean;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Kevin W
 */
public class DistrictServiceImpl implements DistrictService {
    
    @Autowired
    Mapper mapper;
    
    @Autowired
    DistrictRepository repo;

    @Override
    public DistrictBean updateEntity(DistrictBean entity) {
        District dst = mapper.map(entity, District.class);
        dst = repo.save(dst);
        mapper.map(dst,entity);
        return entity;
    }

    @Override
    public void deleteEntity(DistrictBean entity) {
        this.deleteByID(entity.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repo.delete(id);
    }

    @Override
    public DistrictBean getByID(Long id) {
        DistrictBean dst = new DistrictBean();
        mapper.map(repo.findOne(id), dst);
        return dst;
    }

    @Override
    public List<DistrictBean> getAll() {
        List<DistrictBean> newlist = new ArrayList<>();
        Iterable<District> list = repo.findAll();
        for(District gp : list) {
            newlist.add(mapper.map(gp, DistrictBean.class));
        }
        return newlist;
    }
    
}
