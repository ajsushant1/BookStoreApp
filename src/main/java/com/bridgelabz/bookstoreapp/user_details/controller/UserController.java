package com.bridgelabz.bookstoreapp.user_details.controller;

import com.bridgelabz.bookstoreapp.user_details.dto.UserDTO;
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

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationDetails> registerUser(@RequestBody UserDTO userDTO){
        UserRegistrationDetails userRegistrationDetails = userService.registerUser(userDTO);
        return new ResponseEntity<>(userRegistrationDetails, HttpStatus.CREATED);
    }
}
