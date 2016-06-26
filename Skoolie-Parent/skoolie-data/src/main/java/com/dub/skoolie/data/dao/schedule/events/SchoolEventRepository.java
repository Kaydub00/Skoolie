/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.schedule.events;

import com.dub.skoolie.data.entities.schedule.events.SchoolEvent;
import com.dub.skoolie.data.entities.school.School;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kevin W
 */
public interface SchoolEventRepository extends JpaRepository<SchoolEvent, Long>{
    
    public List<SchoolEvent> findBySchool(School school);
    
}
