/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.people.faculty;

import com.dub.skoolie.data.entities.district.District;
import com.dub.skoolie.data.entities.usr.security.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Kevin W
 */
@Entity
@Table(name = "PPL_DISTRICT_ADMINS")
public class DistrictAdmin implements Serializable {
    
    @Id
    @Column(name="USER_USERNAME", length=50)
    private String username;
    
    @JoinColumn(name = "USERNAME", nullable=true, insertable=true, updatable=true)
    @OneToOne
    private User user;
    
    @Column(name="ADDRESS_ONE", length=180)
    private String addressOne;
    
    @Column(name="ADDRESS_TWO", length=180)
    private String addressTwo;
    
    @Column(name="CITY", length=120)
    private String city;
    
    @Column(name="POSTAL", length=10)
    private String postal;
    
    @Column(name="STATE", length=40)
    private String state;
    
    @Column(name="RACE", length=40)
    private String race;
    
    @Column(name="GENDER", length=20)
    private String gender;
    
    @Column(name="DOB")
    private Date dob;
    
    @ManyToOne
    @JoinColumn(name="DISTRICT_ID")
    private District district;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
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
     * @return the postal
     */
    public String getPostal() {
        return postal;
    }

    /**
     * @param postal the postal to set
     */
    public void setPostal(String postal) {
        this.postal = postal;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
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

    /**
     * @return the addressOne
     */
    public String getAddressOne() {
        return addressOne;
    }

    /**
     * @param addressOne the addressOne to set
     */
    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    /**
     * @return the addressTwo
     */
    public String getAddressTwo() {
        return addressTwo;
    }

    /**
     * @param addressTwo the addressTwo to set
     */
    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    /**
     * @return the district
     */
    public District getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(District district) {
        this.district = district;
    }

    
}
