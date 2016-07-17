/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.district;

import com.dub.skoolie.structures.district.DistrictBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiDistrictService {
    
    public List<DistrictBean> getDistricts();
    
    public void updateDistrict(DistrictBean db);
    
    public void addDistrict(DistrictBean db);
    
    public DistrictBean getDistrict(Long id);
    
    
}
