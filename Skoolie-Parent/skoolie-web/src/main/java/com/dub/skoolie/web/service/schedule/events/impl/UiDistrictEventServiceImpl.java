/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.events.impl;

import com.dub.skoolie.business.service.schedule.events.DistrictEventService;
import com.dub.skoolie.structures.district.DistrictBean;
import com.dub.skoolie.structures.schedule.events.DistrictEventBean;
import com.dub.skoolie.web.service.schedule.events.UiDistrictEventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiDistrictEventServiceImpl implements UiDistrictEventService {
    
    @Autowired
    DistrictEventService districtEventServiceImpl;

    @Override
    public List<DistrictEventBean> getDistrictEvents() {
        return districtEventServiceImpl.getAll();
    }

    @Override
    public void updateDistrictEvent(DistrictEventBean de) {
        districtEventServiceImpl.updateEntity(de);
    }

    @Override
    public void addDistrictEvent(DistrictEventBean de) {
        districtEventServiceImpl.updateEntity(de);
    }

    @Override
    public DistrictEventBean getDistrictEvent(Long id) {
        return districtEventServiceImpl.getByID(id);
    }

    @Override
    public void deleteDistrictEvent(Long id) {
        districtEventServiceImpl.deleteByID(id);
    }

    @Override
    public List<DistrictEventBean> getDistrictEventsByDistrict(Long id) {
        return districtEventServiceImpl.getDistrictsByDistrictId(id);
    }

    @Override
    public List<DistrictEventBean> getDistrictEventsByDistrict(DistrictBean district) {
        return districtEventServiceImpl.getDistrictsByDistrict(district);
    }
    
}
