package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.model.NewUserData;

import javax.mail.MessagingException;

public interface IMailService {

    void sendRegisterMail(NewUserData newUserData) throws MessagingException;

    void sendForgetPasswordMail(NewUserData newUserData, String jwt) throws MessagingException;

}
