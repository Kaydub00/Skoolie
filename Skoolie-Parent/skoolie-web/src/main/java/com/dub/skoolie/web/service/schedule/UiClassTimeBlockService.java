/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule;

import com.dub.skoolie.structures.schedule.ClassTimeBlockBean;
import com.dub.skoolie.structures.schedule.GradingPeriodBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiClassTimeBlockService {
    
    public List<ClassTimeBlockBean> getClassTimeBlocks();
    
    public void updateClassTimeBlock(ClassTimeBlockBean ctb);
    
    public void addClassTimeBlock(ClassTimeBlockBean ctb);
    
    public ClassTimeBlockBean getClassTimeBlock(Long id);
    
    public List<GradingPeriodBean> getGradingPeriods();
    
    public void deleteClassTimeBlock(Long id);
    
}
