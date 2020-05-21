package com.bridgelabz.bookstoreapp.customer.controller;

import com.bridgelabz.bookstoreapp.customer.dto.CustomerDTO;
import com.bridgelabz.bookstoreapp.customer.model.Customer;
import com.bridgelabz.bookstoreapp.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    final
    CustomerServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }
}
