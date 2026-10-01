package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service 
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int customerId){
        return customerRepository.findById(customerId).orElse(null);
    }

    public void deleteCustomerById(int customerId){
        customerRepository.deleteById(customerId);
    }

    public void createCustomer(String firstName, String lastName, LocalDate birthDate, String phone, String address, String city, String state, int points){
        Customer customer = new Customer(firstName, lastName, birthDate, phone, address, city, state, points);

        customerRepository.save(customer);
    }

    public void updateCustomer(int customerID, String firstName, String lastName, LocalDate birthDate, String phone, String address, String city, String state, int points){
        Customer customer = customerRepository.findById(customerID).orElseThrow(
            () -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, 
            "Customer not found"
        ));

        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setBirthDate(birthDate);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setState(state);
        customer.setPoints(points);

        customerRepository.save(customer);
    }

    public void updateCustomerPoints(int customerID, int addPoints){
        Customer customer = customerRepository.findById(customerID).orElseThrow(
            () -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, 
            "Customer not found"
        ));

        int newPoints = customer.getPoints() + addPoints;
        customer.setPoints(newPoints);
        customerRepository.save(customer);
    }
    
}
