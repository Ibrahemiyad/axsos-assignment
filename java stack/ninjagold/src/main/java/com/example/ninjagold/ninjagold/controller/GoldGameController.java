package com.example.ninjagold.ninjagold.controller;


    


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.*;

@Controller
public class GoldGameController {

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
        }
        if (session.getAttribute("activities") == null) {
            session.setAttribute("activities", new ArrayList<>());
        }
        if (session.getAttribute("earned") == null) {
            session.setAttribute("earned", "green");
        }

        model.addAttribute("gold", session.getAttribute("gold"));
        model.addAttribute("activities", session.getAttribute("activities"));
        model.addAttribute("earned", session.getAttribute("earned"));

        return "ninja.jsp"; // Ensure you have an index.html template in Thymeleaf
    }

    @PostMapping("/process")
    public String processGold(@RequestParam String location, HttpSession session) {
        Map<String, int[]> goldRanges = Map.of(
                "farm", new int[]{10, 20},
                "cave", new int[]{5, 10},
                "house", new int[]{2, 5},
                "quest", new int[]{-50, 50}
        );

        if (!goldRanges.containsKey(location)) {
            return "redirect:/";
        }

        int goldEarned = new Random().nextInt(goldRanges.get(location)[1] - goldRanges.get(location)[0] + 1) + goldRanges.get(location)[0];

        int currentGold = (int) session.getAttribute("gold");
        session.setAttribute("gold", currentGold + goldEarned);

        List<String> activities = (List<String>) session.getAttribute("activities");
        activities.add(0, String.format("You %s %d gold from the %s! (%s)",
                goldEarned >= 0 ? "earned" : "lost", Math.abs(goldEarned), location, new Date()));

        session.setAttribute("activities", activities);

        return "redirect:/";
    }

    @GetMapping("/process_gold")
    public String processGoldGet(HttpSession session) {
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteSession(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

