package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
