/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.school;

import com.dub.skoolie.data.entities.school.School;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Gaming
 */
public interface SchoolRepository extends CrudRepository<School, Long> {
    
}
