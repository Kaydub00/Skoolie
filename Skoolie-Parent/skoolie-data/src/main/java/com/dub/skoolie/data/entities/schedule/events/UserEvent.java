/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.entities.schedule.events;

import com.dub.skoolie.data.entities.usr.security.User;
import java.util.Date;

/**
 *
 * @author Kevin W
 */
public class UserEvent {
    
    private Long id;
    
    private String name;
    
    private Date start;
    
    private Date end;
    
    private User user;
    
}
