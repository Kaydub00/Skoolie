/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule.events;

import com.dub.skoolie.business.service.BaseCrudService;
import com.dub.skoolie.structures.schedule.events.SchoolEventBean;
import com.dub.skoolie.structures.school.SchoolBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface SchoolEventService extends BaseCrudService<SchoolEventBean,Long>{
    
    public List<SchoolEventBean> getSchoolEventsBySchoolId(Long id);
    
    public List<SchoolEventBean> getSchoolEventsBySchool(SchoolBean school);
    
}
