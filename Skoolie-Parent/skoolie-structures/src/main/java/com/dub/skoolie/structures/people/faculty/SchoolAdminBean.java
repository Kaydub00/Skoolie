/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.people.faculty;

import com.dub.skoolie.structures.people.MailableUserPerson;
import com.dub.skoolie.structures.school.SchoolBean;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Kevin W
 */
public class SchoolAdminBean extends MailableUserPerson implements Serializable {
    
    private SchoolBean primarySchool;    

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
     * @return the race
     */
    public String getRace() {
        return race;
    }

    /**
     * @param race the race to set
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
}
