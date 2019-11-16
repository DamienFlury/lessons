package ch.bbw.df.foodtracker.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.bbw.df.foodtracker.FoodRepository;
import ch.bbw.df.foodtracker.models.Food;

@RestController
public class FoodController {

    private final FoodRepository repository;
    public FoodController(FoodRepository repository) {
        this.repository = repository;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/foods")
    public List<Food> hello() {
        return repository.getAll();
    }

}