/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.impl;

import com.dub.skoolie.business.service.schedule.SchoolYearService;
import com.dub.skoolie.business.service.school.SchoolService;
import com.dub.skoolie.structures.schedule.SchoolYearBean;
import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.web.service.schedule.UiSchoolYearService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiSchoolYearServiceImpl implements UiSchoolYearService {
    
    @Autowired
    SchoolYearService schoolYearServiceImpl;
    
    @Autowired
    SchoolService schoolServiceImpl;

    @Override
    public List<SchoolYearBean> getSchoolYears() {
        return schoolYearServiceImpl.getAll();
    }

    @Override
    public void updateSchoolYear(SchoolYearBean skl) {
        schoolYearServiceImpl.updateEntity(skl);
    }

    @Override
    public void addSchoolYear(SchoolYearBean skl) {
        schoolYearServiceImpl.updateEntity(skl);
    }

    @Override
    public SchoolYearBean getSchoolYear(Long id) {
        return schoolYearServiceImpl.getByID(id);
    }
    
    @Override
    public List<SchoolBean> getAllSchools() {
        return schoolServiceImpl.getAll();
    }

    @Override
    public void deleteSchoolYear(Long id) {
        schoolYearServiceImpl.deleteByID(id);
    }

    @Override
    public List<SchoolYearBean> getSchoolYearsBySchoolId(Long id) {
        return schoolYearServiceImpl.getSchoolYearBySchoolId(id);
    }

    @Override
    public List<SchoolYearBean> getSchoolYearsBySchool(SchoolBean school) {
        return schoolYearServiceImpl.getSchoolYearBySchool(school);
    }
    
    
    
}
