/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.school.impl;

import com.dub.skoolie.business.service.school.SchoolRoomService;
import com.dub.skoolie.structures.school.SchoolBean;
import com.dub.skoolie.structures.school.SchoolRoomBean;
import com.dub.skoolie.web.service.school.UiSchoolRoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class UiSchoolRoomServiceImpl implements UiSchoolRoomService {
    
    @Autowired
    SchoolRoomService schoolRoomServiceImpl;

    @Override
    public List<SchoolRoomBean> getSchoolRooms() {
        return schoolRoomServiceImpl.getAll();
    }

    @Override
    public void updateSchoolRoom(SchoolRoomBean skl) {
        schoolRoomServiceImpl.updateEntity(skl);
    }

    @Override
    public void addSchoolRoom(SchoolRoomBean skl) {
        schoolRoomServiceImpl.updateEntity(skl);
    }

    @Override
    public SchoolRoomBean getSchoolRoom(Long id) {
        return schoolRoomServiceImpl.getByID(id);
    }

    @Override
    public List<SchoolRoomBean> getSchoolRoomsBySchool(SchoolBean skl) {
        return schoolRoomServiceImpl.getSchoolRoomsBySchool(skl);
    }

    @Override
    public List<SchoolRoomBean> getSchoolRoomsBySchool(Long id) {
        return schoolRoomServiceImpl.getSchoolRoomsBySchoolId(id);
    }

    @Override
    public void deleteSchoolRoom(SchoolRoomBean skl) {
        schoolRoomServiceImpl.deleteEntity(skl);
    }

    @Override
    public void deleteSchoolRoom(Long id) {
        schoolRoomServiceImpl.deleteByID(id);
    }
    
    
}
