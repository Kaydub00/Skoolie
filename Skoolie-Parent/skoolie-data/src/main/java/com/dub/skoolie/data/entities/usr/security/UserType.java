/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.usr.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gaming
 */
@Entity
@Table(name = "USR_TYPE")
public class UserType {
    
    @Id
    @Column(name="NAME", length=50)
    private String name;
    
}
