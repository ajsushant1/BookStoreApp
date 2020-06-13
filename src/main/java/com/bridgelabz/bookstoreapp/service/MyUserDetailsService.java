package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.MyUserDetails;
import com.bridgelabz.bookstoreapp.model.UserRegistrationDetails;
import com.bridgelabz.bookstoreapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserRegistrationDetails> user = userRepository.findByEmail(userName);
        System.out.println(user);
        user.orElseThrow(() -> new UsernameNotFoundException("User Not Found : " + userName));
        return user.map(MyUserDetails::new).get();
    }
}
