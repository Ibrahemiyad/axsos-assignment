package com.example.route.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class RouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouteApplication.class, args);
	}

	@RequestMapping("/dakini")
	public String dakini(){
		return "Welcome";

	}

	@RequestMapping("/dakini/today")
	public String today(){
		return "Today you will find luck in all your endeavors!";
						
	}

	@RequestMapping("/dakini/tommorow")
	public String tommorow(){
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!!";
						

	}
	





}
