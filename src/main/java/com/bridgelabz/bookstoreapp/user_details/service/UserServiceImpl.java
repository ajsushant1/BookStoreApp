package com.bridgelabz.bookstoreapp.user_details.service;

import com.bridgelabz.bookstoreapp.user_details.dto.UserDTO;
import com.bridgelabz.bookstoreapp.user_details.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.user_details.model.UserRegistrationDetails;
import com.bridgelabz.bookstoreapp.user_details.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserRegistrationDetails registerUser(UserDTO userDTO) throws UserRegistrationException {
        UserRegistrationDetails registrationDetails = modelMapper.map(userDTO, UserRegistrationDetails.class);
        if (!userRepository.findByEmail(registrationDetails.getEmail()).isEmpty())
            throw new UserRegistrationException(UserRegistrationException.ExceptionType.ALREADY_REGISTERED,
                    "Email Id Already Registered");
        return userRepository.save(registrationDetails);
    }
}
