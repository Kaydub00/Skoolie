/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.schedule;

import com.dub.skoolie.data.entities.schedule.SchoolYear;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kevin W
 */
public interface SchoolYearRepository extends CrudRepository<SchoolYear, Long>{
    
}
