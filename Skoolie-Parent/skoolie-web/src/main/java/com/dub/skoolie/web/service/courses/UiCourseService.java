/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.courses;

import com.dub.skoolie.structures.courses.CourseBean;
import com.dub.skoolie.structures.courses.SubjectBean;
import com.dub.skoolie.structures.school.SchoolBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiCourseService {
    
    public List<CourseBean> getCourses();
    
    public CourseBean getCourse(Long id);
    
    public void updateCourse(CourseBean subject);
    
    public void addCourse(CourseBean subject);
    
    public void deleteCourseById(Long id);
    
    public void deleteCourse(CourseBean subject);
    
    public List<CourseBean> getCoursesBySchool(Long id);
    
    public List<CourseBean> getCoursesBySchool(SchoolBean school);
    
    public List<CourseBean> getCoursesBySubject(Long id);
    
    public List<CourseBean> getCoursesBySubject(SubjectBean subject);
    
}
