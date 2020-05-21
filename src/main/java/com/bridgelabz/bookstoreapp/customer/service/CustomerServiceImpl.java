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

    @Override
    public Customer updateCustomer(long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id).get();
        customer.setAddress(customerDTO.getAddress());
        customer.setAddressType(customerDTO.getAddressType());
        customer.setCity(customerDTO.getCity());
        customer.setLandmark(customerDTO.getLandmark());
        customer.setLocality(customerDTO.getLocality());
        customer.setName(customerDTO.getName());
        customer.setPinCode(customerDTO.getPinCode());
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(long id) {
        return customerRepository.findById(id).get();
    }
}
