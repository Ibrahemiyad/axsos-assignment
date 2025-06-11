package com.example.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.example.login.models.Book;
import com.example.login.repositories.BookRepository;
import com.example.login.models.User;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    public Book findBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Book addBook(Book book, BindingResult result, User user) {
        if (result.hasErrors()) {
            return null;
        }
        book.setUser(user);
        return bookRepo.save(book);
    }

    public Book updateBook(Long id, Book bookDetails, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }
        Book book = findBookById(id);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setDescription(bookDetails.getDescription());
            return bookRepo.save(book);
        }
        return null;
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}