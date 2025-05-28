package com.example.axsosacademy.bookapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.axsosacademy.bookapi.models.Book;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findByDescriptionContaining(String search);
    List<Book> findByTitleContaining(String search);
    List<Book> findByLanguageContaining(String search);

    
}  


