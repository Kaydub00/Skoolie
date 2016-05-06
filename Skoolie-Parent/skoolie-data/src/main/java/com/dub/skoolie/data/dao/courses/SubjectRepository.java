/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.courses;

import com.dub.skoolie.data.entities.courses.Subject;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kevin W
 */
public interface SubjectRepository extends CrudRepository<Subject, Long>{
    
}
