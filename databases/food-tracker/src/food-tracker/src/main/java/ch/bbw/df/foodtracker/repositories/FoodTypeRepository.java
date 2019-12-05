
package ch.bbw.df.foodtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.bbw.df.foodtracker.models.FoodType;

public interface FoodTypeRepository extends JpaRepository<FoodType, Integer> {

}