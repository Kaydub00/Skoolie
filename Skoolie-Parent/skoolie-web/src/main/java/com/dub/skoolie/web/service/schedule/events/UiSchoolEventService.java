/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.events;

import com.dub.skoolie.structures.schedule.events.SchoolEventBean;
import com.dub.skoolie.structures.school.SchoolBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiSchoolEventService {
    
    public List<SchoolEventBean> getSchoolEvents();
    
    public void updateSchoolEvent(SchoolEventBean se);
    
    public void addSchoolEvent(SchoolEventBean se);
    
    public SchoolEventBean getSchoolEvent(Long id);
    
    public void deleteSchoolEvent(Long id);
    
    public List<SchoolEventBean> getSchoolEventsBySchool(Long id);
    
    public List<SchoolEventBean> getSchoolEventsBySchool(SchoolBean school);
    
}
