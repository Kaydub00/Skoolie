/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.schedule;

import com.dub.skoolie.data.entities.schedule.GradingPeriod;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kevin W
 */
public interface GradingPeriodRepository extends CrudRepository<GradingPeriod, Long>{
    
    @Query("select e from GradingPeriod e "
            + "where e.schoolYear.school.id = ?1")
    public List<GradingPeriod> findGradingPeriodBySchoolId(Long id);
    
    @Query("select e from GradingPeriod e where e.schoolYear.school.id = ?1" + 
            " and e.startDate < current_date() and e.endDate > current_date()")
    public GradingPeriod findCurrentGradingPeriodBySchoolId(Long id);
    
}
