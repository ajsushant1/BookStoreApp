package com.bridgelabz.bookstoreapp.mailsender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements IMailService {


    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail(String receiver,String userName) throws MessagingException {
        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setSubject("Thank you for registering");
        helper.setTo(receiver);
        helper.setText("Dear "+userName+",\n" +
                "\n" +
                "Thank you for your registration. If you have any questions, please let me know!.\n" +
                "\n" +
                "Thank you , Have great day,",false);
        javaMailSender.send(message);
    }
}
