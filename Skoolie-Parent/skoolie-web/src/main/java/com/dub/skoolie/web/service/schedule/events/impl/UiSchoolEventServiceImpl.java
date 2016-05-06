/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.events.impl;

import com.dub.skoolie.business.service.schedule.events.SchoolEventService;
import com.dub.skoolie.structures.schedule.events.SchoolEventBean;
import com.dub.skoolie.web.service.schedule.events.UiSchoolEventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiSchoolEventServiceImpl implements UiSchoolEventService {
    
    @Autowired
    SchoolEventService schoolEventServiceImpl;

    @Override
    public List<SchoolEventBean> getSchoolEvents() {
        return schoolEventServiceImpl.getAll();
    }

    @Override
    public void updateSchoolEvent(SchoolEventBean se) {
        schoolEventServiceImpl.updateEntity(se);
    }

    @Override
    public void addSchoolEvent(SchoolEventBean se) {
        schoolEventServiceImpl.updateEntity(se);
    }

    @Override
    public SchoolEventBean getSchoolEvent(Long id) {
        return schoolEventServiceImpl.getByID(id);
    }

    @Override
    public void deleteSchoolEvent(Long id) {
        schoolEventServiceImpl.deleteByID(id);
    }
    
}
