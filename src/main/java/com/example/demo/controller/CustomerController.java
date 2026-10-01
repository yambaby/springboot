package com.example.demo.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AddPointsRequest;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import jakarta.validation.Valid;

@Validated 
@RestController 
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> customer(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomerById(@PathVariable int id){
        customerService.deleteCustomerById(id);
    }

    @PostMapping("/customers")
    public void createCustomer(@Valid @RequestBody Customer customer){
        customerService.createCustomer(
            customer.getFirstName(),
            customer.getLastName(),
            customer.getBirthDate(),
            customer.getPhone(),
            customer.getAddress(),
            customer.getCity(),
            customer.getState(),
            customer.getPoints()
        );
    }

    @PutMapping("/customers/{id}")
    public void updateCustomer(@Valid @RequestBody Customer customer, @PathVariable int id){
        customerService.updateCustomer(
            id, 
            customer.getFirstName(),
            customer.getLastName(),
            customer.getBirthDate(),
            customer.getPhone(),
            customer.getAddress(),
            customer.getCity(),
            customer.getState(),
            customer.getPoints()
        );
    }

    @PostMapping("/customers/{id}/points")
    public void updateCustomerPoints(
        @PathVariable int id,
        @Valid @RequestBody AddPointsRequest addPointsRequest){
        customerService.updateCustomerPoints(
            id, 
            addPointsRequest.getAddPoints()
        );
    }
}
