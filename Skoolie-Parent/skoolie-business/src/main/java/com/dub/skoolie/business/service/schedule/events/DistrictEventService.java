/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.schedule.events;

import com.dub.skoolie.business.service.BaseCrudService;
import com.dub.skoolie.structures.district.DistrictBean;
import com.dub.skoolie.structures.schedule.events.DistrictEventBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface DistrictEventService extends BaseCrudService<DistrictEventBean,Long>{
    
    public List<DistrictEventBean> getDistrictsByDistrictId(Long id);
    
    public List<DistrictEventBean> getDistrictsByDistrict(DistrictBean district);
    
    
}
