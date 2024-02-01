package io.github.ndimovt.bookstore.repository;

import io.github.ndimovt.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    String deleteByBookName(String name);
    Book findByBookName(String bookName);


}
