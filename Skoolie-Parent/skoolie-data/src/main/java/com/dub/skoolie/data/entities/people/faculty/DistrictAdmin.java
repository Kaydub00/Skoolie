/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.people.faculty;

import com.dub.skoolie.data.entities.usr.security.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
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

    
}
