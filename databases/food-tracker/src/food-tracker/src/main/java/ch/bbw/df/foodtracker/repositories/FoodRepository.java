package ch.bbw.df.foodtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.bbw.df.foodtracker.models.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

}