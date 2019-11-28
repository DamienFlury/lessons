package ch.bbw.df.foodtracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.bbw.df.foodtracker.models.Customer;
import ch.bbw.df.foodtracker.models.Food;
import ch.bbw.df.foodtracker.repositories.CustomerRepository;
import ch.bbw.df.foodtracker.repositories.FoodRepository;

@RestController
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/foods")
    public ResponseEntity<?> getFoods() {

        var customer = Customer
            .builder()
            .firstName("Test")
            .lastName("Yeet")
            .build();
        var food = Food
            .builder()
            .name("Bananas")
            .price(1.95)
            .customer(customer)
            .build();

        customerRepository.save(customer);
        foodRepository.save(food);
        return ResponseEntity.ok(foodRepository.findAll());
    }
}