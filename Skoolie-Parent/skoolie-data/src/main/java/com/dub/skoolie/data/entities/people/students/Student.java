/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.people.students;

import com.dub.skoolie.data.entities.school.School;
import com.dub.skoolie.data.entities.usr.security.User;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Kevin W
 */
@Entity
@Table(name = "PPL_STUDENTS")
public class Student implements Serializable {
    
    @Id
    @Column(name="USERNAME", length=50)
    private String username;
    
    @JoinColumn(name = "USERNAME")
    @OneToOne
    @MapsId
    private User user;
    
    @Column(name="ADDRESS", length=180)
    private String address;
    
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
    @JoinColumn(name="PRIMARY_SCHOOL_ID")
    private School primarySchool;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(
            name="USR_STUDENT_SCHOOLS",
            joinColumns = @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME"),
            inverseJoinColumns = @JoinColumn(name = "SCHOOL_ID", referencedColumnName = "ID")
    )
    private List<School> availableSchools;
    
}
