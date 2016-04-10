/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.school.impl;

import com.dub.skoolie.business.service.school.SchoolService;
import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.web.service.school.UiSchoolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiSchoolServiceImpl implements UiSchoolService {
    
    @Autowired
    SchoolService schoolServiceImpl;

    @Override
    public List<SchoolBean> getSchools() {
        return schoolServiceImpl.getAll();
    }

    @Override
    public void updateSchool(SchoolBean skl) {
        schoolServiceImpl.updateEntity(skl);
    }

    @Override
    public void addSchool(SchoolBean skl) {
        schoolServiceImpl.updateEntity(skl);
    }

    @Override
    public SchoolBean getSchool(Long id) {
        return schoolServiceImpl.getByID(id);
    }
    
}
