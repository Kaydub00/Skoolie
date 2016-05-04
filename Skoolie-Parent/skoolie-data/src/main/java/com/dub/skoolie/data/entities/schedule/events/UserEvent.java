/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.schedule.events;

import com.dub.skoolie.data.entities.usr.security.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kevin W
 */
@Entity
@Table(name = "EVT_USER_EVENTS")
public class UserEvent implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    
    @Column(name="NAME", length=140)
    private String name;
    
    @Column(name="START_DATE_TIME")
    private Date start;
    
    @Column(name="END_DATE_TIME")
    private Date end;
    
    private User user;
    
}
