package com.example.pathvariable.pathvariable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/daikichi")

@SpringBootApplication
public class PathvariableApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathvariableApplication.class, args);
	}

    @RequestMapping("/travel/{city}")
    public String travel(@PathVariable String city) {
        return "Congratulations! You will soon travel to " + city + "!";
    }

    @RequestMapping("/lotto/{number}")
    public String lotto(@PathVariable int number) {
        if (number % 2 == 0) {
            return "You will take a grand journey in the near future but be wary of tempting offers.";
        } else {
            return "You have enjoyed the fruits of your labor, but now is a great time to spend time with family and friends.";
        }
    }
}	

