/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.web.service.courses;

import com.dub.skoolie.structures.courses.SubjectBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiSubjectService {
    
    public List<SubjectBean> getSubjects();
    
    public SubjectBean getSubject(Long id);
    
    public void updateSubject(SubjectBean subject);
    
    public void addSubject(SubjectBean subject);
    
    public void deleteSubjectById(Long id);
    
    public void deleteSubject(SubjectBean subject);
    
}
