package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.model.UserDetails;
import com.bridgelabz.bookstoreapp.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@CrossOrigin
@RestController
@RequestMapping("/mail-sender")
public class MailSenderController {

    @Autowired
    IMailService mailService;

    @PostMapping("/send-mail")
    public String sendMail(@RequestBody UserDetails userDetails) throws MessagingException {
        mailService.sendMail(userDetails);
        return "Mail Sent";
    }
}
