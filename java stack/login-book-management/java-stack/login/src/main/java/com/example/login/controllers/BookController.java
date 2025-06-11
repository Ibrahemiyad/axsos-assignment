package com.example.login.controllers;

import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.servlet.http.HttpSession;

import com.example.login.models.Book;
import com.example.login.models.User;
import com.example.login.services.BookService;
import com.example.login.services.UserService;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping("/books")
    public String listBooks(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        User user = userService.findUserById(userId);
        List<Book> books = bookService.findBooksByUser(user);
        model.addAttribute("books", books);
        return "bookList";
    }

    @GetMapping("/books/add")
    public String addBookForm(Model model) {
        model.addAttribute("newBook", new Book());
        return "addBook";
    }

    @PostMapping("/books/add")
    public String addBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "addBook";
        }
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        newBook.setUser(user);
        bookService.saveBook(newBook);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "editBook";
        }
        book.setId(id);
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}