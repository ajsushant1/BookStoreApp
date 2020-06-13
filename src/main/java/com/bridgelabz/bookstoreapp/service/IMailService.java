package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.model.UserDetails;

import javax.mail.MessagingException;

public interface IMailService {
    void sendMail(UserDetails userDetails) throws MessagingException;
}
