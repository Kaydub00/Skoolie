/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.people.students;

import com.dub.skoolie.data.entities.people.students.Student;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kevin W
 */
public interface StudentRepository extends CrudRepository<Student, String> {
    
    @Query("select e from Student e "
            + "where e.primarySchool.id = ?1")
    public List<Student> findStudentsBySchoolId(Long id);
    
}
