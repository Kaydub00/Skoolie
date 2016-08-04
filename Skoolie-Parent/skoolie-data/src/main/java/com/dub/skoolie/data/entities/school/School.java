/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.school;

import com.dub.skoolie.data.entities.district.District;
import com.dub.skoolie.data.entities.schedule.SchoolYear;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Kevin W
 */
@Entity
@Table(name = "SCL_SCHOOL")
public class School implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    
    @Column(name="NAME", length=180)
    private String name;
    
    @Column(name="ADDRESS", length=180)
    private String address;
    
    @Column(name="CITY", length=180)
    private String city;
    
    @Column(name="STATE", length=180)
    private String state;
    
    @Column(name="POSTAL", length=12)
    private String postal;
    
    @Column(name="PHONE", length=20)
    private String phone;
    
    @OneToMany(mappedBy="school", cascade = CascadeType.ALL)
    private List<SchoolYear> schoolYears;
    
    @OneToMany(mappedBy="school", cascade = CascadeType.ALL)
    private List<SchoolRoom> schoolRooms;
    
    @ManyToOne
    @JoinColumn(name="DISTRICT_ID")
    private District district;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(
            name="SCL_GRADE_LEVELS",
            joinColumns = @JoinColumn(name = "SCHOOL_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "GRADE_LEVEL_ID", referencedColumnName = "ID")
    )
    private List<GradeLevel> gradeLevels;

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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
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
    public List<SchoolYear> getSchoolYears() {
        return schoolYears;
    }

    /**
     * @param schoolYears the schoolYears to set
     */
    public void setSchoolYears(List<SchoolYear> schoolYears) {
        this.schoolYears = schoolYears;
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

    /**
     * @return the schoolRooms
     */
    public List<SchoolRoom> getSchoolRooms() {
        return schoolRooms;
    }

    /**
     * @param schoolRooms the schoolRooms to set
     */
    public void setSchoolRooms(List<SchoolRoom> schoolRooms) {
        this.schoolRooms = schoolRooms;
    }

    /**
     * @return the gradeLevels
     */
    public List<GradeLevel> getGradeLevels() {
        return gradeLevels;
    }

    /**
     * @param gradeLevels the gradeLevels to set
     */
    public void setGradeLevels(List<GradeLevel> gradeLevels) {
        this.gradeLevels = gradeLevels;
    }
    
}
