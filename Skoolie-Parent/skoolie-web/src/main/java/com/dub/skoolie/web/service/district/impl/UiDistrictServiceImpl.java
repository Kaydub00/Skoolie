/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.district.impl;

import com.dub.skoolie.business.service.district.DistrictService;
import com.dub.skoolie.structures.district.DistrictBean;
import com.dub.skoolie.web.service.district.UiDistrictService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiDistrictServiceImpl implements UiDistrictService {
    
    @Autowired
    DistrictService districtServiceImpl;

    @Override
    public List<DistrictBean> getDistricts() {
        return districtServiceImpl.getAll();
    }

    @Override
    public void updateDistrict(DistrictBean db) {
        districtServiceImpl.updateEntity(db);
    }

    @Override
    public void addDistrict(DistrictBean db) {
        districtServiceImpl.updateEntity(db);
    }

    @Override
    public DistrictBean getDistrict(Long id) {
        return districtServiceImpl.getByID(id);
    }

    
    
}
