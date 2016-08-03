/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.utils.email;

import javax.mail.Message;

/**
 *
 * @author Kevin W
 */
public interface EmailService {
    
    public void sendEmail(String to, String from, String subject, String msg);
    
    public void sendMessageAsEmail(Message msg);
    
}
