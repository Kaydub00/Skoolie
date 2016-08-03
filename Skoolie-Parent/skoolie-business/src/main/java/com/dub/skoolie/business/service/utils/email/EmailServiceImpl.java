/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.business.service.utils.email;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendEmail(String to, String from, String subject, String msg) {
        try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "localhost");
            Session emailSession = Session.getDefaultInstance(properties);
            Message emailMessage = new MimeMessage(emailSession);
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            emailMessage.setFrom(new InternetAddress(from));
            emailMessage.setSubject(subject);
            emailMessage.setText(msg);
            Transport.send(emailMessage);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendMessageAsEmail(Message msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
