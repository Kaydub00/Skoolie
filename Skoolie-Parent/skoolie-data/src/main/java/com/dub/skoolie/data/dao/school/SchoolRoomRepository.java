/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.school;

import com.dub.skoolie.data.entities.school.School;
import com.dub.skoolie.data.entities.school.SchoolRoom;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kevin W
 */
public interface SchoolRoomRepository extends CrudRepository<SchoolRoom, Long> {
    
    @Query("select r from SchoolRoom r "
            + "where r.school.id = ?1")
    List<SchoolRoom> findSchoolRoomsBySchoolId(Long id);
    
    public List<SchoolRoom> findBySchool(School school);
}
