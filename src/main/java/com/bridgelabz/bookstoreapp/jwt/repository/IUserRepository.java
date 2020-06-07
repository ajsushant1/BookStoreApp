package com.bridgelabz.bookstoreapp.jwt.repository;

import com.bridgelabz.bookstoreapp.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
