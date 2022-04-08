package com.VHS.fakelews.controller;


import com.VHS.fakelews.Customer;
import com.VHS.fakelews.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class demoController {
    @Autowired
    private CustomerRepository customerRepository;




    @PostMapping("/add")
    public String addCustomer(@RequestParam String first, @RequestParam String last){
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "Added new customer to repo!";
    }
    @GetMapping("/list")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }
}
