/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule;

import com.dub.skoolie.business.service.BaseCrudService;
import com.dub.skoolie.structures.schedule.ClassTimeBlockBean;
import com.dub.skoolie.structures.schedule.GradingPeriodBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface ClassTimeBlockService extends BaseCrudService<ClassTimeBlockBean,Long>{
    
    public List<ClassTimeBlockBean> getClassTimeBlocksByGradingPeriod(GradingPeriodBean gradingPeriodBean);
    
    public List<ClassTimeBlockBean> getClassTimeBlocksByGradingPeriod(Long id);
    
}
