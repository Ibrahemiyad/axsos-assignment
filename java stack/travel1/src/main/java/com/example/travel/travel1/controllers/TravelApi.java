package com.example.travel.travel1.controllers;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.travel.travel1.models.Travel;
import com.example.travel.travel1.services.TravelServices;

import jakarta.validation.Valid;

import java.util.List;

@Controller
public class TravelApi {
    private final TravelServices travelServices;
    public TravelApi(TravelServices travelServices) {
        this.travelServices = travelServices;
    }
    @GetMapping("/")
    public String index(Model model, @ModelAttribute("travel") Travel travel) {
        List<Travel> travels = travelServices.AllTravels();
        model.addAttribute("travels", travels); // Add travels to the model
        return "index.jsp"; // Return the index view
    }

    @PostMapping("/add")
    public String addTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index.jsp"; // Return to index if there are errors
        }
        travelServices.saveTravel(travel); // Save the travel object using the service
        // Removed unused variable declaration
        model.addAttribute("travel", new Travel()); // Reset the travel object in the model
        return "redirect:/"; // Redirect to the index page after saving
    }

    @RequestMapping("/edit/{id}") 
    public String edit(@PathVariable("id") Long id, Model model) {
        Travel travel = travelServices.findTravelById(id);
        model.addAttribute("travel",travel );
        return "edit.jsp";

    }

    @RequestMapping("/travel/{id}")
    public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("travel", travel);
            return "edit.jsp";
        } else {
            travelServices.updateTravel(travel);
            return "redirect:/";
        }
    }
    @RequestMapping(value="/travel/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        travelServices.deleteTravel(id);
        return "redirect:/";
    }

    @RequestMapping("/details/{id}")
    public String showTravel(@PathVariable("id") Long id, Model model) {
        Travel travel = travelServices.findTravelById(id);
        model.addAttribute("travel", travel);
        return "expense.jsp";
    }


}
