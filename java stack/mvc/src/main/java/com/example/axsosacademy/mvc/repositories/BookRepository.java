package com.example.axsosacademy.mvc.repositories;

import com.example.axsosacademy.mvc.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
