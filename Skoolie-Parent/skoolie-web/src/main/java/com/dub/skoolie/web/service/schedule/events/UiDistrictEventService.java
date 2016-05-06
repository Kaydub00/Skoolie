/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.schedule.events;

import com.dub.skoolie.structures.schedule.events.DistrictEventBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiDistrictEventService {
    
    public List<DistrictEventBean> getDistrictEvents();
    
    public void updateDistrictEvent(DistrictEventBean de);
    
    public void addDistrictEvent(DistrictEventBean de);
    
    public DistrictEventBean getDistrictEvent(Long id);
    
    public void deleteDistrictEvent(Long id);
    
}
