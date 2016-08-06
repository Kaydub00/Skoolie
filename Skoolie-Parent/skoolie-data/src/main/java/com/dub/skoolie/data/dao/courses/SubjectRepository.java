/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.courses;

import com.dub.skoolie.data.entities.courses.Subject;
import com.dub.skoolie.data.entities.school.School;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kevin W
 */
public interface SubjectRepository extends CrudRepository<Subject, Long>{
    
    @Query("select s from Subject s where s.school.id = ?1")
    public List<Subject> findSubjectBySchoolId(Long id);
    
    public List<Subject> findBySchool(School school);
}
