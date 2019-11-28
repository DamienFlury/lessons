package ch.bbw.df.foodtracker.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.bbw.df.foodtracker.models.Customer;
import ch.bbw.df.foodtracker.repositories.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}