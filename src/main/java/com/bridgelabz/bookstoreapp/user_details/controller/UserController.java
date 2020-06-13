package com.bridgelabz.bookstoreapp.user_details.controller;

import com.bridgelabz.bookstoreapp.user_details.dto.UserDTO;
import com.bridgelabz.bookstoreapp.user_details.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.user_details.model.UserRegistrationDetails;
import com.bridgelabz.bookstoreapp.user_details.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        try {
            UserRegistrationDetails userRegistrationDetails = userService.registerUser(userDTO);
        } catch (UserRegistrationException e) {
            return new ResponseEntity<>("User Already Registered", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("User Registered Successfully", HttpStatus.CREATED);
    }
}
