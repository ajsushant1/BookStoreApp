package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.UserRegistrationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRegistrationDetails, Long> {
    public Optional<UserRegistrationDetails> findByEmail(String email);
}
