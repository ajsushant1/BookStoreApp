package com.bridgelabz.bookstoreapp.user_details.repository;

import com.bridgelabz.bookstoreapp.user_details.model.UserRegistrationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRegistrationDetails,Long> {
}
