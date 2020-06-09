package com.bridgelabz.bookstoreapp.user_details.service;

import com.bridgelabz.bookstoreapp.user_details.dto.UserDTO;
import com.bridgelabz.bookstoreapp.user_details.model.UserRegistrationDetails;

public interface IUserService {
    UserRegistrationDetails registerUser(UserDTO userDTO);
}
