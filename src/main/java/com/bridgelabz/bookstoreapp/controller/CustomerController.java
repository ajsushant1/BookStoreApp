package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.customer.dto.CustomerDTO;
import com.bridgelabz.bookstoreapp.customer.model.Customer;
import com.bridgelabz.bookstoreapp.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    final
    CustomerServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add-customer")
    public Customer addCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }

    @PutMapping("/update-customer/{id}")
    public Customer updateCustomer(@PathVariable long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(id, customerDTO);
    }

    @GetMapping("/get-customer/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return customerService.getCustomer(id);
    }
}
