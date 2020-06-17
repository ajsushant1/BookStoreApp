package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.CustomerDto;
import com.bridgelabz.bookstoreapp.exception.CustomerException;
import com.bridgelabz.bookstoreapp.model.Customer;
import com.bridgelabz.bookstoreapp.repository.ICustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param customerDto
     * @return Add customer details to the database
     */
    @Override
    public Customer addCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return customerRepository.save(customer);
    }

    /**
     * @param customerId
     * @param customerDto
     * @return
     */
    @Override
    public Customer updateCustomer(Long customerId, CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customer.setId(customerId);
        return customerRepository.save(customer);
    }

    @Override
    public void removeCustomer(Long customerId) throws CustomerException {
        if (customerRepository.findById(customerId).isPresent())
            customerRepository.deleteById(customerId);
        else throw new CustomerException(CustomerException.ExceptionType.CUSTOMER_NOT_FOUND, "CUSTOMER_NOT_FOUND");
    }

    @Override
    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId).get();
    }
}
