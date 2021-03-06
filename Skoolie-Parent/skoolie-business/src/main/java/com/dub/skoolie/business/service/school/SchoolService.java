/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.school;

import com.dub.skoolie.business.service.BaseCrudService;
import com.dub.skoolie.structures.school.GradeLevelBean;
import com.dub.skoolie.structures.school.SchoolBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface SchoolService extends BaseCrudService<SchoolBean,Long> {
    
    public List<GradeLevelBean> getAvailableGradeLevels();
    
}
