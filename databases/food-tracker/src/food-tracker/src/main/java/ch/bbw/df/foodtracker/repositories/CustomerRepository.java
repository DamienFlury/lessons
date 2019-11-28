package ch.bbw.df.foodtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.bbw.df.foodtracker.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}