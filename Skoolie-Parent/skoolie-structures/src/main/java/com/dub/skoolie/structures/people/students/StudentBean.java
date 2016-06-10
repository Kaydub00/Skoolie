/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.people.students;

import com.dub.skoolie.structures.people.MailableUserPerson;
import com.dub.skoolie.structures.school.SchoolBean;
import java.io.Serializable;

/**
 *
 * @author Kevin W
 */
public class StudentBean extends MailableUserPerson implements Serializable {
    
    private SchoolBean primarySchool;
    
    //May have mailing address different than address
    
    //Do we need a local student id?

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
    
}
