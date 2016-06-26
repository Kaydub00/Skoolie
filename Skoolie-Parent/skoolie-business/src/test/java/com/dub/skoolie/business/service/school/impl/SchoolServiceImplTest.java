/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.school.impl;

import com.dub.skoolie.data.dao.school.SchoolRepository;
import com.dub.skoolie.data.entities.school.School;
import com.dub.skoolie.structures.school.SchoolBean;
import java.lang.reflect.Field;
import org.dozer.Mapper;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Kevin W
 */
public class SchoolServiceImplTest {
    
    @Rule 
    public JUnitRuleMockery context = new JUnitRuleMockery();
    
    public SchoolRepository repository;
    public Mapper mapper;
    
    private SchoolServiceImpl classToTest = new SchoolServiceImpl();
    
    //@Before
    public void setup() throws Exception {
        repository = context.mock(SchoolRepository.class);
        mapper = context.mock(Mapper.class);
        
        Field fieldRepo = classToTest.getClass().getDeclaredField("repo");
        Field fieldMapper = classToTest.getClass().getDeclaredField("mapper");
        
        fieldRepo.setAccessible(true);
        fieldRepo.set(classToTest, repository);
        fieldMapper.setAccessible(true);
        fieldMapper.set(classToTest, mapper);
    }
    
    //@Test
    public void testUpdateEntity() throws Exception {
        final SchoolBean school = new SchoolBean();
        school.setAddress("123 fake st");
        school.setCity("fake city");
        school.setName("fake school");
        school.setPhone("727-867-5309");
        school.setPostal("33778");
        school.setState("FL");
        
        
        
        
        context.checking(new Expectations() {{ 
            //oneOf(mapper).map(school, new School());
            atLeast(1).of(mapper).map(school, School.class);
        }
        });
        classToTest.updateEntity(school);
        
        context.assertIsSatisfied();
    }
    
}
