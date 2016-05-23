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
        return schoolAdminServiceImpl.getAll();
    }

    @Override
    public SchoolAdminBean getSchoolAdmin(String username) {
        return schoolAdminServiceImpl.getByID(username);
    }

    @Override
    public void updateSchoolAdmin(SchoolAdminBean user) {
        schoolAdminServiceImpl.updateEntity(user);
    }

    @Override
    public void addSchoolAdmin(SchoolAdminBean user) {
        schoolAdminServiceImpl.updateEntity(user);
    }

    @Override
    public void deleteSchoolAdminByUsername(String username) {
        schoolAdminServiceImpl.deleteByID(username);
    }

    @Override
    public void deleteSchoolAdmin(SchoolAdminBean user) {
        schoolAdminServiceImpl.deleteEntity(user);
    }
    
}
