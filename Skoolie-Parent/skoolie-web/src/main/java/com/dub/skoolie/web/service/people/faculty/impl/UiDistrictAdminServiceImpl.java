/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.people.faculty.impl;

import com.dub.skoolie.business.service.people.faculty.DistrictAdminService;
import com.dub.skoolie.structures.people.faculty.DistrictAdminBean;
import com.dub.skoolie.web.service.people.faculty.UiDistrictAdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiDistrictAdminServiceImpl implements UiDistrictAdminService {
    
    @Autowired
    DistrictAdminService districtAdminServiceImpl;

    @Override
    public List<DistrictAdminBean> getDistrictAdmins() {
        return districtAdminServiceImpl.getAll();
    }

    @Override
    public DistrictAdminBean getDistrictAdmin(String username) {
        return districtAdminServiceImpl.getByID(username);
    }

    @Override
    public void updateDistrictAdmin(DistrictAdminBean user) {
        districtAdminServiceImpl.updateEntity(user);
    }

    @Override
    public void addDistrictAdmin(DistrictAdminBean user) {
        districtAdminServiceImpl.updateEntity(user);
    }

    @Override
    public void deleteDistrictAdminByUsername(String username) {
        districtAdminServiceImpl.deleteByID(username);
    }

    @Override
    public void deleteDistrictAdmin(DistrictAdminBean user) {
        districtAdminServiceImpl.deleteEntity(user);
    }
    
}
