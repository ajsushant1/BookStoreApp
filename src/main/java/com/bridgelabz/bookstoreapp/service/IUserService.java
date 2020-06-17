package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.UserDto;
import com.bridgelabz.bookstoreapp.exception.UserException;
import com.bridgelabz.bookstoreapp.model.User;

import java.util.Optional;

public interface IUserService {
    User registerUser(UserDto userDto) throws UserException;

    Optional<User> getUserByEmail(String email);

    User updateUser(UserDto userDto, Long id);
}
