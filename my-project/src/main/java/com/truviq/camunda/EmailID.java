package com.truviq.camunda;


import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.pvm.delegate.ActivityBehavior;
import org.camunda.bpm.engine.impl.pvm.delegate.ActivityExecution;

public class EmailID implements JavaDelegate {

  public static void sendEmail(String recipientMail, String mSubject, String mBody) throws MessagingException {
    // Define email server properties
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.ssl.trust", "*");
    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    // Create a new session with an authenticator
    Session session = Session.getInstance(props, new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("truviqs@gmail.com", "jllyqimsyyoqzlwm");
      }
    });

    // Create a new message
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress("truviqs@gmail.com"));
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientMail));
    message.setSubject(mSubject);
    message.setText(mBody);

    // Send the message
    Transport.send(message);
  }

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    String mBody1 ="Due Task";
     String  mSubject1 = "please review task";
    String recipientMail1 = "kotharisridevi964@gmail.com";

    sendEmail(recipientMail1, mSubject1, mBody1);
  }


}