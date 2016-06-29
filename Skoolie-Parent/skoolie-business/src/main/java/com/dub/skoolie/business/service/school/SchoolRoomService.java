/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.school;

import com.dub.skoolie.business.service.BaseCrudService;
import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.structures.school.SchoolRoomBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface SchoolRoomService extends BaseCrudService<SchoolRoomBean,Long> {
    
    public List<SchoolRoomBean> getSchoolRoomsBySchoolId(Long id);
    
    public List<SchoolRoomBean> getSchoolRoomsBySchool(SchoolBean school);
}
