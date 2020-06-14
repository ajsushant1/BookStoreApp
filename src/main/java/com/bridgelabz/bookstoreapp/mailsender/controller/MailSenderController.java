package com.bridgelabz.bookstoreapp.mailsender.controller;

import com.bridgelabz.bookstoreapp.mailsender.model.NewUserData;
import com.bridgelabz.bookstoreapp.mailsender.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@CrossOrigin
@RestController
@RequestMapping("/mail-sender")
public class MailSenderController {

    @Autowired
    IMailService mailService;

   @PostMapping
    public String sendMail(@RequestBody NewUserData newUserData) throws MessagingException {
        mailService.sendMail(newUserData);
        return "Mail Sent";
    }
}
