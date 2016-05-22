/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.people.faculty;

import com.dub.skoolie.structures.people.faculty.SchoolAdminBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiSchoolAdminService {
    
    public List<SchoolAdminBean> getSchoolAdmins();
    
    public SchoolAdminBean getSchoolAdmin(String username);
    
    public void updateSchoolAdmin(SchoolAdminBean user);
    
    public void addSchoolAdmin(SchoolAdminBean user);
    
    public void deleteSchoolAdminByUsername(String username);
    
    public void deleteSchoolAdmin(SchoolAdminBean user);
    
}
