package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.UserDto;
import com.bridgelabz.bookstoreapp.exception.UserException;
import com.bridgelabz.bookstoreapp.model.User;
import com.bridgelabz.bookstoreapp.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param userDto
     * @return Register new user for authentication
     * @throws UserException
     */
    @Override
    public User registerUser(UserDto userDto) throws UserException {
        User user = modelMapper.map(userDto, User.class);
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new UserException(UserException.ExceptionType.ALREADY_REGISTERED, "Email Id Already Registered");
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User updateUser(UserDto userDto, Long id) {
        User user = modelMapper.map(userDto, User.class);
        user.setUserId(id);
        return userRepository.save(user);
    }
}
