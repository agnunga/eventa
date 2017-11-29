/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xag.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendMailTLS {

    private static final String username = "yolojeya@gmail.com";
    private static final String password = "pzpoaarxutxasluw";
    private static final Logger log = LoggerFactory.getLogger(MailObject.class);

    public static boolean sendMail(MailObject mo) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mo.getTo()));
            message.setSubject(mo.getMessageSubject());
            message.setText(mo.getMessageBody());

            Transport.send(message);
            log.info("Mail sent!");
            return true;

        } catch (MessagingException e) {
            log.error("Mail sending failed: " + e.getMessage());
            return false;
        }
    }
}
