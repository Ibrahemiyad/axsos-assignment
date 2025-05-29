// package com.example.axsosacademy.mvc.controller;

// import com.example.axsosacademy.mvc.models.Book;
// import com.example.axsosacademy.mvc.services.BookService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// public class BooksApi {
//     private final BookService bookService;

//     public BooksApi(BookService bookService) {
//         this.bookService = bookService;
//     }

//     @PutMapping("/api/books/{id}")
//     public Book update(
//         @PathVariable("id") Long id,
//         @RequestParam("title") String title,
//         @RequestParam("description") String desc,
//         @RequestParam("language") String lang,
//         @RequestParam("pages") Integer numOfPages
//     ) {
//         return bookService.updateBook(id, title, desc, lang, numOfPages);
//     }

//     @DeleteMapping("/api/books/{id}")
//     public void destroy(@PathVariable("id") Long id) {
//         bookService.deleteBook(id);
//     }
// }





