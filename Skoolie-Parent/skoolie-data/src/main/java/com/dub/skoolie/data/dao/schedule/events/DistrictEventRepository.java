/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.schedule.events;

import com.dub.skoolie.data.entities.district.District;
import com.dub.skoolie.data.entities.schedule.events.DistrictEvent;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kevin W
 */
public interface DistrictEventRepository extends CrudRepository<DistrictEvent, Long>{
    
    public List<DistrictEvent> findByDistrict(District district);
    
    @Query("select e from DistrictEvent e "
            + "where e.district.id = ?1")
    List<DistrictEvent> findDistrictEventsByDistrictId(Long id);
    
}
