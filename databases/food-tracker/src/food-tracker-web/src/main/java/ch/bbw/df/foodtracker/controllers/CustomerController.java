package ch.bbw.df.foodtracker.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.bbw.df.foodtracker.CustomerRepository;
import ch.bbw.df.foodtracker.models.Customer;

@RestController
public class CustomerController {
    private final CustomerRepository repository;
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/customers")
    public List<Customer> get() {
        return repository.findAll();
    }
}