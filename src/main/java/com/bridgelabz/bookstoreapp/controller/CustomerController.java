package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.CustomerDto;
import com.bridgelabz.bookstoreapp.exception.CustomerException;
import com.bridgelabz.bookstoreapp.model.Customer;
import com.bridgelabz.bookstoreapp.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")

public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    /**
     * @param customerDto
     * @return Add customer details to the database
     */
    @PostMapping
    public Customer addCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.addCustomer(customerDto);
    }

    /**
     * @param customerId
     * @param customerDto
     * @return Update customer details of given customer id
     * @throws CustomerException
     */
    @PutMapping("/{customerId}")
    public Customer updateCustomerDetails(@PathVariable Long customerId, @RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerId, customerDto);
    }

    /**
     * @param customerId
     * @throws CustomerException
     */
    @DeleteMapping("/{customer-id}")
    public void removeCustomer(@PathVariable(value = "customer-id") Long customerId) throws CustomerException {
        customerService.removeCustomer(customerId);
    }

    /**
     * @return Customer details of particular customer id
     */
    @GetMapping("/{customer-id}")
    public Customer getCustomer(@PathVariable(value = "customer-id") Long customerId) {
        return customerService.getCustomer(customerId);
    }
}
