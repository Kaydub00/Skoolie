/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.schedule.events;

import com.dub.skoolie.data.entities.schedule.events.SchoolEvent;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kevin W
 */
public interface SchoolEventRepository extends CrudRepository<SchoolEvent, Long>{
    
}
