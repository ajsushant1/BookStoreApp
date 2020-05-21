package com.bridgelabz.bookstoreapp.customer.service;

import com.bridgelabz.bookstoreapp.customer.dto.CustomerDTO;
import com.bridgelabz.bookstoreapp.customer.model.Customer;
import com.bridgelabz.bookstoreapp.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    final
    CustomerRepository customerRepository;

    final
    ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Customer addCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        return customerRepository.save(customer);
    }
}
