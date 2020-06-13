package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.user_details.dto.UserDTO;
import com.bridgelabz.bookstoreapp.user_details.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.user_details.model.UserRegistrationDetails;

public interface IUserService {
    public UserRegistrationDetails registerUser(UserDTO userDTO) throws UserRegistrationException;
}
