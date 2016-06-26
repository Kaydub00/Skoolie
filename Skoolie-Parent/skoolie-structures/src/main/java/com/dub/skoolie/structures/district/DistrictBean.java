/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.district;

import com.dub.skoolie.structures.school.SchoolBean;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Kevin W
 */
public class DistrictBean implements Serializable {
    
    private Long id;
    
    @NotNull
    @Size(min=4, max=180)
    private String name;
    
    private List<SchoolBean> schools;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the schools
     */
    public List<SchoolBean> getSchools() {
        return schools;
    }

    /**
     * @param schools the schools to set
     */
    public void setSchools(List<SchoolBean> schools) {
        this.schools = schools;
    }
    
}
