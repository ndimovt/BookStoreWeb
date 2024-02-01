package io.github.ndimovt.bookstore.service;

import io.github.ndimovt.bookstore.entity.Book;
import io.github.ndimovt.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;
    public Book addBook(Book book){
        return repository.save(book);
    }
    public List<Book> getAllBooks(){
        return repository.findAll();
    }
    @Transactional
    public String delete(String name){
        repository.deleteByBookName(name);
        return "Product Deleted";
    }
    public Book getBook(String bookName){
        return repository.findByBookName(bookName);
    }
    public Book updatePrice(Book book){
        Book existingBook = repository.findByBookName(book.getBookName());
        existingBook.setPrice(book.getPrice());
        return repository.save(existingBook);
    }
}
