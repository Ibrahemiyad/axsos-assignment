package com.example.ninjagold.ninjagold.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller

public class NinjaController {

    @GetMapping("/")
	public String index(HttpSession session) {
		
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("red", "red");
			session.setAttribute("green", "green");

	        }
		
		return "index.jsp";
	}
	
	@PostMapping("/earngold")
	public String earnGold(@RequestParam(value="place") String place,HttpSession session) {
		Date date = new Date();
		String timeStamp = date.toString();
		Random random = new Random();
        int randomGold=0;
        Integer gold=0;
        String msg;
        List<String> messages = (List<String>) session.getAttribute("messages");
        if (messages == null) {
            messages = new ArrayList<>();
        }
        
		switch(place) {
		  case "farm":
		    // code block
			   randomGold = random.nextInt(21);
		       gold = (Integer) session.getAttribute("gold");
		       gold += randomGold;
		       session.setAttribute("gold", gold);
		       msg=String.format("you entered a %s and earned %d gold. %s", place, randomGold, timeStamp);
		       messages.add(0,msg);
		       session.setAttribute("messages", messages);
		    break;
		  case "cave":
		    // code block
			   randomGold = random.nextInt(6)+5;
		       gold = (Integer) session.getAttribute("gold");
		       gold += randomGold;
		       session.setAttribute("gold", gold);
		       msg=String.format("you entered a %s and earned %d gold. %s", place, randomGold, timeStamp);
		       messages.add(0,msg);
		       session.setAttribute("messages", messages);
		    break;
		  case "house":
			    // code block
			   randomGold = random.nextInt(4)+2;
		       gold = (Integer) session.getAttribute("gold");
		       gold += randomGold;
		       session.setAttribute("gold", gold);
		       msg=String.format("you entered a %s and earned %d gold. %s", place, randomGold, timeStamp);
		       messages.add(0,msg);
		       session.setAttribute("messages", messages);
			break;
		  case "quest":
			    // code block
			   randomGold = random.nextInt(101)-50;
		       gold = (Integer) session.getAttribute("gold");
		       gold += randomGold;
		       session.setAttribute("gold", gold);
		       if(randomGold>0) {
		    	   msg=String.format("you entered a %s and earned %d gold. %s", place, randomGold, timeStamp);
			       messages.add(0,msg);
			       session.setAttribute("messages", messages);
			       
		       }else {
		    	   msg=String.format("you entered a %s and lost %d gold. %s", place, randomGold, timeStamp);
			       messages.add(0,msg);
			       
		       }
		       session.setAttribute("messages", messages);
		       break;
		    
		  default:
		    // code block
		}
		
		
	    return "redirect:/";

	}

}
