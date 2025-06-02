package com.example.burger.burger.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.example.burger.burger.models.Burger; // Import the Burger class
import java.util.List; // Import the List class

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
    List <Burger> findAll(); // Method to retrieve all burgers
}
