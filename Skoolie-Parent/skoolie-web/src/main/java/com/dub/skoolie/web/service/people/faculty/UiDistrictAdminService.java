/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.people.faculty;

import com.dub.skoolie.structures.people.faculty.DistrictAdminBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiDistrictAdminService {
    
    public List<DistrictAdminBean> getDistrictAdmins();
    
    public DistrictAdminBean getDistrictAdmin(String username);
    
    public void updateDistrictAdmin(DistrictAdminBean user);
    
    public void addDistrictAdmin(DistrictAdminBean user);
    
    public void deleteDistrictAdminByUsername(String username);
    
    public void deleteDistrictAdmin(DistrictAdminBean user);
    
}
