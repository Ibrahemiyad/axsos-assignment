package com.example.axsosacademy.bookapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.axsosacademy.bookapi.models.Book;
import com.example.axsosacademy.bookapi.services.BookService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/{id}")
    public String showBook(@PathVariable("id") Long id, Model model) {
        System.out.println("Fetching book with ID: " + id); // Debug log
    
        Book book = bookService.findBook(id);
        if (book == null) {
            System.out.println("Book not found for ID: " + id); // Debug log
            model.addAttribute("errorMessage", "Book not found");
            return "error"; // Return error view if book not found
        }
        model.addAttribute("book", book);
        return "index"; // Return a specific view for showing the book
    }}

