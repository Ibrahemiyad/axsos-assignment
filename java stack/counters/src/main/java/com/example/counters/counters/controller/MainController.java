package com.example.counters.counters.controller;

import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
    @RequestMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
        int count = (int) session.getAttribute("count");
        count++;
        session.setAttribute("count", count);
        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String counter(HttpSession session) {
        return "counter.jsp";
    }
}