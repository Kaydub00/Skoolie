/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.courses;

import com.dub.skoolie.data.entities.courses.SchoolClass;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Kevin W
 */
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long>{
    
    
    //@Query("select c from SchoolClass c where c.teacher.user.username = ?1 and c.classTimeBlock.gradingPeriod.startDate < CURRENT_DATE and c.classTimeBlock.gradingPeriod.endDate > CURRENT_DATE")
    @Query(value= "SELECT * FROM CRS_SCHOOL_CLASSES SC JOIN SCHED_CLS_TIME_BLOCK CTB ON SC.CLASS_TIME_BLOCK_ID = CTB.ID JOIN SCHED_GRADING_PERIOD GP ON CTB.GRADING_PERIOD_ID = GP.ID WHERE SC.TEACHER_ID = ?1 AND GP.START_DATE < NOW() AND GP.END_DATE > NOW()", nativeQuery = true)
    public List<SchoolClass> findSchoolClassByCurrentGradingPeriodAndTeacher(String teacherName);
    
    
}
