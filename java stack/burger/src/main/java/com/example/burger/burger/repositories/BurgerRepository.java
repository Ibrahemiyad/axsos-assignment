package com.example.burger.burger.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.example.burger.burger.models.Burger;
import java.util.List; 
@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
    List <Burger> findAll(); 
}
