package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.model.AuthenticationRequest;
import com.bridgelabz.bookstoreapp.model.AuthenticationResponse;
import com.bridgelabz.bookstoreapp.model.NewUserData;
import com.bridgelabz.bookstoreapp.service.IMailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/mail-sender")
@CrossOrigin
public class MailSenderController {

    @Autowired
    IMailService mailService;

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/register")
    public String sendRegisterMail(@RequestBody NewUserData newUserData) throws MessagingException {
        mailService.sendRegisterMail(newUserData);
        return "Mail Sent";
    }

    @PostMapping("/forget-password")
    public ResponseEntity<?> sendResetPasswordMail(@RequestBody NewUserData newUserData) throws MessagingException, Exception {
        ResponseEntity entity = authenticationController.createAuthenticationToken(new AuthenticationRequest(newUserData.getEmail(),newUserData.getPassword()));
        AuthenticationResponse response = modelMapper.map(entity.getBody(), AuthenticationResponse.class);
        mailService.sendForgetPasswordMail(newUserData, response.getJwt());
        return entity;
    }
}
