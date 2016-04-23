/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.school;

import com.dub.skoolie.structures.schedule.SchoolYearBean;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Kevin W
 */
public class SchoolBean implements Serializable {
    
    private Long id;
    
    @NotNull
    @Size(min=4, max=180)
    private String name;
    
    @NotNull
    @Size(min=8, max=180)
    private String address;
    
    @NotNull
    @Size(min=3, max=180)
    private String city;
    
    @NotNull
    @Size(min=2, max=2)
    private String state;
    
    @NotNull
    @Size(min=5, max=10)
    private String postal;
    
    @NotNull
    @Size(min=10, max=20)
    private String phone;
    
    private List<SchoolYearBean> schoolYears;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the schoolYears
     */
    public List<SchoolYearBean> getSchoolYears() {
        return schoolYears;
    }

    /**
     * @param schoolYears the schoolYears to set
     */
    public void setSchoolYears(List<SchoolYearBean> schoolYears) {
        this.schoolYears = schoolYears;
    }
    
}
