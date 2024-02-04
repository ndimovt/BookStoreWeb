package io.github.ndimovt.bookstore.service;

import io.github.ndimovt.bookstore.entity.AuthorSort;
import io.github.ndimovt.bookstore.entity.Book;
import io.github.ndimovt.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;
    public Book add(Book book){
        return repository.save(book);
    }
    public List<Book> getAll(){
        AuthorSort sort = new AuthorSort();
        List<Book> sorted = repository.findAll();
        Collections.sort(sorted, sort);
        return sorted;
    }
    @Transactional
    public String delete(String name){
        repository.deleteByBookName(name);
        return "Product Deleted";
    }
    public List<Book> byAuthor(String name){
        return repository.findByAuthorName(name);
    }
    public Book updatePrice(Book book){
        Book existingBook = repository.findByBookName(book.getBookName());
        existingBook.setPrice(book.getPrice());
        return repository.save(existingBook);
    }
}
