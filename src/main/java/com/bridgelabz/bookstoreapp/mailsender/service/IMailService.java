package com.bridgelabz.bookstoreapp.mailsender.service;

import com.bridgelabz.bookstoreapp.mailsender.model.NewUserData;

import javax.mail.MessagingException;

public interface IMailService {
    void sendMail(NewUserData newUserData) throws MessagingException;
}
