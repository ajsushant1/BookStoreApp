package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
