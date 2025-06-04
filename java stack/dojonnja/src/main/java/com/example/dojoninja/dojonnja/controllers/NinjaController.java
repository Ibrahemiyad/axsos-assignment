package com.example.dojoninja.dojonnja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojoninja.dojonnja.models.Ninja;
import com.example.dojoninja.dojonnja.services.DojoService;
import com.example.dojoninja.dojonnja.services.NinjaService;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class NinjaController {
    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/ninjas/new")
    public String newNinja(Model model) {
        model.addAttribute("ninja", new Ninja());
        model.addAttribute("dojos", dojoService.allDojos());
        return "newNinja.jsp"; 
    }

    @PostMapping("/ninjas")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("dojos", dojoService.allDojos()); // re-add dojos on error
            return "newNinja.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/dojos/" + ninja.getDojo().getId(); // redirect to dojo detail
        }
    }
}
