package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.CustomerDto;
import com.bridgelabz.bookstoreapp.exception.CustomerException;
import com.bridgelabz.bookstoreapp.model.Customer;

public interface ICustomerService {
    Customer addCustomer(CustomerDto customerDto);

    Customer updateCustomer(Long customerId, CustomerDto orderQuantity);

    void removeCustomer(Long customerId) throws CustomerException;

    Customer getCustomer(Long customerId);
}
