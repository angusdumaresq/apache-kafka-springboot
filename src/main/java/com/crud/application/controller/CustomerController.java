package com.crud.application.controller;

import com.crud.application.model.Customer;
import com.crud.application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/createCustomer")
    Customer createCustomer(@RequestBody Customer newCustomer) { return customerService.createCustomer(newCustomer); }
}
