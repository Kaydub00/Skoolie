/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.people.faculty.impl;

import com.dub.skoolie.business.service.people.faculty.SchoolAdminService;
import com.dub.skoolie.structures.people.faculty.SchoolAdminBean;
import com.dub.skoolie.web.service.people.faculty.UiSchoolAdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiSchoolAdminServiceImpl implements UiSchoolAdminService {
    
    @Autowired
    SchoolAdminService schoolAdminServiceImpl;
    

    @Override
    public List<SchoolAdminBean> getSchoolAdmins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SchoolAdminBean getSchoolAdmin(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSchoolAdmin(SchoolAdminBean user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSchoolAdmin(SchoolAdminBean user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSchoolAdminByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSchoolAdmin(SchoolAdminBean user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
