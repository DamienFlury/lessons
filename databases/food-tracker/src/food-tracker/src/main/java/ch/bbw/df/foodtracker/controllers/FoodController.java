package ch.bbw.df.foodtracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.bbw.df.foodtracker.models.Customer;
import ch.bbw.df.foodtracker.models.Food;
import ch.bbw.df.foodtracker.repositories.CustomerRepository;
import ch.bbw.df.foodtracker.repositories.FoodRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;


    @GetMapping("/foods")
    public ResponseEntity<?> getFoods() {
        return ResponseEntity.ok(foodRepository.findAll());
    }
    
    @PostMapping("/foods")
    public Food postFood(@RequestBody Food food) {
        if(food.getId() != null && foodRepository.findById(food.getId()) != null) {
            return null;
        }
        return foodRepository.save(food);
    }

    @DeleteMapping("/foods/{id}")
    public void deleteFood(@PathVariable int id) {
        foodRepository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("foods/{id}")
    public Food updateFood(@PathVariable int id, @RequestBody Food food) {
        food.setId(id);
        return foodRepository.save(food);
    }
}