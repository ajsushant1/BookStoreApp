package com.bridgelabz.bookstoreapp.mailsender.service;

import javax.mail.MessagingException;

public interface IMailService {
    void sendMail(String to, String userName) throws MessagingException;
}
