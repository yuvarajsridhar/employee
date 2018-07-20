package com.yuvaraj.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
 public  void send( String to,String sub,String msg) {
	Properties properties=new Properties();
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.socketFactory.port", "465");  
	 properties.put("mail.smtp.socketFactory.class",         
             "javax.net.ssl.SSLSocketFactory");    
	 properties.put("mail.smtp.auth", "true");    
     properties.put("mail.smtp.port", "465");  
     Session session = Session.getDefaultInstance(properties,    
             new javax.mail.Authenticator() {    
             protected PasswordAuthentication getPasswordAuthentication() {    
             return new PasswordAuthentication("syuvraj8@gmail.com","");  
             }    
            });      try {    
                MimeMessage message = new MimeMessage(session);    
                message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
                message.setSubject(sub);    
                message.setText(msg);    
                //send message  
                Transport.send(message);    
                System.out.println("message sent successfully");    
               } catch (MessagingException e) {throw new RuntimeException(e);}    
                  
         }  

}
