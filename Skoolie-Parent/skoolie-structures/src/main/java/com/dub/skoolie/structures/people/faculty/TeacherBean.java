/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.people.faculty;

import com.dub.skoolie.structures.people.MailableUserPerson;
import com.dub.skoolie.structures.school.SchoolBean;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public class TeacherBean extends MailableUserPerson implements Serializable {
    
    private SchoolBean primarySchool;
    
    private List<SchoolBean> availableSchools;

    /**
     * @return the primarySchool
     */
    public SchoolBean getPrimarySchool() {
        return primarySchool;
    }

    /**
     * @param primarySchool the primarySchool to set
     */
    public void setPrimarySchool(SchoolBean primarySchool) {
        this.primarySchool = primarySchool;
    }

    /**
     * @return the availableSchools
     */
    public List<SchoolBean> getAvailableSchools() {
        return availableSchools;
    }

    /**
     * @param availableSchools the availableSchools to set
     */
    public void setAvailableSchools(List<SchoolBean> availableSchools) {
        this.availableSchools = availableSchools;
    }
    
}
