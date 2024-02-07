package io.github.ndimovt.bookstore.repository;

import io.github.ndimovt.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface BookRepository extends JpaRepository<Book, Integer> {
    String deleteById(int id);
    Book findByBookName(String bookName);
    ArrayList<Book> findByAuthorName(String authorName);


}
