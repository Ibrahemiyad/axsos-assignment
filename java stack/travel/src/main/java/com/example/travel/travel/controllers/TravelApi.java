package com.example.travel.travel.controllers;

import com.example.travel.travel.services.TravelService; // Ensure this path matches the actual location of TravelService
import org.springframework.web.bind.annotation.GetMapping; // Import for GetMapping annotation
import org.springframework.web.bind.annotation.PostMapping; // Import for PostMapping annotation
import org.springframework.validation.BindingResult; // Import for BindingResult type
import org.springframework.stereotype.Controller; // Import for Controller annotation

import java.util.List;

import org.springframework.ui.Model; // Import for Model type
import org.springframework.web.bind.annotation.ModelAttribute; // Import for ModelAttribute annotation
import com.example.travel.travel.models.Travel; // Import for Travel type

@Controller
public class TravelApi {

    private final TravelService travelService;
    public TravelApi(TravelService travelService) {
        this.travelService = travelService;
    }
    @GetMapping("/")
    public String index(Model model, @ModelAttribute("travel") Travel travel) {
        List<Travel> travels = travelService.getAllTravels();
        return "index"; // Return the index view
    }

    @PostMapping("/add")
    public String addTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index"; // Return to index if there are errors
        }
        travelService.saveTravel(travel); // Save the travel object using the service
        model.addAttribute("travel", new Travel()); // Reset the travel object in the model
        return "redirect:/"; // Redirect to the index page after saving
    }

}