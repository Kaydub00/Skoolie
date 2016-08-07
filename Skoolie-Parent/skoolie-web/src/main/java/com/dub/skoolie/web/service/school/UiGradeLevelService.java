/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.school;

import com.dub.skoolie.structures.school.GradeLevelBean;
import java.util.List;

/**
 *
 * @author kevinw
 */
public interface UiGradeLevelService {
    
    public List<GradeLevelBean> getGradeLevels();
    
    public void updateGradeLevel(GradeLevelBean glb);
    
    public void addGradeLevel(GradeLevelBean glb);
    
    public GradeLevelBean getGradeLevel(Long id);
    
}
