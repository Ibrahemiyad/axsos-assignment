package com.example.burger.burger.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.burger.burger.repositories.BurgerRepository; // Import the BurgerRepository
import com.example.burger.burger.models.Burger; // Import the Burger model

@Service
public class BurgerService {
    private final BurgerRepository burgerRepository;
    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }
    public void saveBurger(Burger burger) {
        burgerRepository.save(burger);
    }
    public Burger findBurgerById(Long id) {
        return burgerRepository.findById(id).orElse(null); // Return null if Burger is not found
    }
    public void updateBurger(Burger burger) {
        burgerRepository.save(burger); // Save the updated burger
    }
    public void deleteBurger(Long id) {
        burgerRepository.deleteById(id); // Delete the burger by its ID
    }
    public void createBurger(Burger burger) {
        burgerRepository.save(burger); // Save the new burger
    }
}
