/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.people.faculty;

import com.dub.skoolie.structures.district.DistrictBean;
import com.dub.skoolie.structures.people.MailableUserPerson;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Kevin W
 */
public class DistrictAdminBean extends MailableUserPerson implements Serializable {
    
    private DistrictBean district;

    /**
     * @return the district
     */
    public DistrictBean getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(DistrictBean district) {
        this.district = district;
    }
    
}
