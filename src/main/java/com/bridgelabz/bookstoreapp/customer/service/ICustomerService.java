package com.bridgelabz.bookstoreapp.customer.service;

import com.bridgelabz.bookstoreapp.customer.dto.CustomerDTO;
import com.bridgelabz.bookstoreapp.customer.model.Customer;

public interface ICustomerService {
    Customer addCustomer(CustomerDTO customerDTO);
    Customer updateCustomer(long id, CustomerDTO customerDTO);
}
