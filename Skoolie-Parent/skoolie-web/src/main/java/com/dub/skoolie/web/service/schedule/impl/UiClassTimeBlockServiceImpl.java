/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.impl;

import com.dub.skoolie.business.service.schedule.ClassTimeBlockService;
import com.dub.skoolie.business.service.schedule.GradingPeriodService;
import com.dub.skoolie.structures.schedule.ClassTimeBlockBean;
import com.dub.skoolie.structures.schedule.GradingPeriodBean;
import com.dub.skoolie.web.service.schedule.UiClassTimeBlockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiClassTimeBlockServiceImpl implements UiClassTimeBlockService {
    
    @Autowired
    ClassTimeBlockService classTimeBlockServiceImpl;
    
    @Autowired
    GradingPeriodService gradingPeriodServiceImpl;

    @Override
    public List<ClassTimeBlockBean> getClassTimeBlocks() {
        return classTimeBlockServiceImpl.getAll();
    }

    @Override
    public void updateClassTimeBlock(ClassTimeBlockBean ctb) {
        classTimeBlockServiceImpl.updateEntity(ctb);
    }

    @Override
    public void addClassTimeBlock(ClassTimeBlockBean ctb) {
        classTimeBlockServiceImpl.updateEntity(ctb);
    }

    @Override
    public ClassTimeBlockBean getClassTimeBlock(Long id) {
        return classTimeBlockServiceImpl.getByID(id);
    }

    @Override
    public List<GradingPeriodBean> getGradingPeriods() {
        return gradingPeriodServiceImpl.getAll();
    }
    
}
