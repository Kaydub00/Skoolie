/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.school.impl;

import com.dub.skoolie.business.service.school.GradeLevelService;
import com.dub.skoolie.structures.school.GradeLevelBean;
import com.dub.skoolie.web.service.school.UiGradeLevelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kevinw
 */
@Service
public class UiGradeLevelServiceImpl implements UiGradeLevelService{
    
    @Autowired
    GradeLevelService gradeLevelServiceImpl;

    @Override
    public List<GradeLevelBean> getGradeLevels() {
        return gradeLevelServiceImpl.getAll();
    }

    @Override
    public void updateGradeLevel(GradeLevelBean glb) {
        gradeLevelServiceImpl.updateEntity(glb);
    }

    @Override
    public void addGradeLevel(GradeLevelBean glb) {
        gradeLevelServiceImpl.updateEntity(glb);
    }

    @Override
    public GradeLevelBean getGradeLevel(Long id) {
        return gradeLevelServiceImpl.getByID(id);
    }
    
}
