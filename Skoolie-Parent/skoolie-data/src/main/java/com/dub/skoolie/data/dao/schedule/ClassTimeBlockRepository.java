/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.schedule;

import com.dub.skoolie.data.entities.schedule.ClassTimeBlock;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kevin W
 */
public interface ClassTimeBlockRepository extends CrudRepository<ClassTimeBlock, Long>{
    
    @Query("select c from ClassTimeBlock c "
            + "where c.gradingPeriod.id = ?1")
    public List<ClassTimeBlock> findClassTimeBlocksByGradingPeriodId(Long id);
    
}
