package com.example.human.human;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class HumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanApplication.class, args);
	}
	@RequestMapping("/")
	public String hello(){
		return "Hello Human";
	}

	@RequestMapping("name")
    public String index(@RequestParam(value="name") String searchQuery) {
        return "Hello " + searchQuery;
	}

	@RequestMapping("lname")
    public String index1(@RequestParam(value="name") String searchQuery, @RequestParam(value="l_name") String l_name) {
        return "Hello " + searchQuery + " " + l_name;
	}

	@RequestMapping("kname")
    public String index2(@RequestParam(value="name") String searchQuery1, @RequestParam(value="time") int times) {
		String result ="";
		for (int i=1; i<=times;i++){

			result+= "Hello " + searchQuery1;

		}
		return result;
	}










}
