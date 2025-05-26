package com.example.date1.date1.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {

        @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("/date")
    public String date(Model model){
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
        String formattedDate = dateFormat.format(new Date());
        model.addAttribute("formattedDate", formattedDate);
        return "date.jsp";
    }

    @RequestMapping("/time")
    public String time(Model model) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String formattedTime = timeFormat.format(new Date());
        model.addAttribute("formattedTime", formattedTime);
        return "time.jsp";
    }

}
