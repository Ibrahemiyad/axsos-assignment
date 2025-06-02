package com.example.burger.burger.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.burger.burger.services.BurgerService; // Import the BurgerService class

import jakarta.validation.Valid;

import com.example.burger.burger.models.Burger; // Import the Burger class

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;

@Controller
public class BurgerApi {
    private final BurgerService burgerService;

    public BurgerApi(BurgerService burgerService) {
        this.burgerService = burgerService;
    }
    // @ModelAttribute("burger")
    // public Burger setUpBurgerForm() {
    //     return new Burger();
    // }
    @GetMapping("/") // Maps the root URL to the index method
    public String index(Model model,@ModelAttribute("burger") Burger burger) {
        List<Burger> burgers = burgerService.allBurgers(); // Retrieve all burgers from the service
        model.addAttribute("burgers", burgers); // Add the list of burgers to the model
        model.addAttribute("burger", new Burger()); // Add a new Burger object to the model
        return "index"; // Return the name of the HTML template to render
    }


    @PostMapping("/add")
    public String create(@Valid@ModelAttribute("burger") Burger burger, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "index";
        } else {
            burgerService.createBurger(burger);
            List<Burger> burgers = burgerService.allBurgers(); // Retrieve updated list of burgers
            model.addAttribute("burgers", burgers); // Add the updated list of burgers to the model
            return "index";
        }
    }


    @RequestMapping("/edit/{id}") 
    public String edit(@PathVariable("id") Long id, Model model) {
        Burger burger = burgerService.findBurgerById(id);
        model.addAttribute("burger",burger );
        return "edit";

    }
    @RequestMapping("/burger/{id}")
    public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("burger", burger);
            return "edit";
        } else {
            burgerService.updateBurger(burger);
            return "redirect:/";
        }
    }

}



    

    


