/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.courses;

import com.dub.skoolie.data.entities.courses.Course;
import com.dub.skoolie.data.entities.courses.Subject;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kevin W
 */
public interface CourseRepository extends CrudRepository<Course, Long>{
    
    @Query("select c from Course c where c.subject.school.id = ?1")
    public List<Course> findCourseBySchoolId(Long id);
    
    @Query("select c from Course c where c.subject.id = ?1")
    public List<Course> findCourseBySubjectId(Long id);
    
    public List<Course> findBySubject(Subject subject);
}
