/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.school;

import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.structures.school.SchoolRoomBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiSchoolRoomService {
    
    public List<SchoolRoomBean> getSchoolRooms();
    
    public void updateSchoolRoom(SchoolRoomBean skl);
    
    public void addSchoolRoom(SchoolRoomBean skl);
    
    public SchoolRoomBean getSchoolRoom(Long id);
    
    public List<SchoolRoomBean> getSchoolRoomsBySchool(SchoolBean skl);
    
    public List<SchoolRoomBean> getSchoolRoomsBySchool(Long id);
    
}
