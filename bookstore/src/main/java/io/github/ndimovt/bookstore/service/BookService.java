package io.github.ndimovt.bookstore.service;

import io.github.ndimovt.bookstore.entity.AuthorSort;
import io.github.ndimovt.bookstore.entity.Book;
import io.github.ndimovt.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;
    public Book add(Book book) {
        ArrayList<Book> fullList = Populate.insert();
        if (!fullList.contains(book)) {
            return repository.save(book);
        }
        return null;
    }
    public ArrayList<Book> getAll(){
        AuthorSort sort = new AuthorSort();
        ArrayList<Book> sorted = (ArrayList<Book>) repository.findAll();
        Collections.sort(sorted, sort);
        return sorted;
    }
    @Transactional
    public String delete(int id){
        repository.deleteById(id);
        return "Product Deleted";
    }
    public ArrayList<Book> byAuthor(String name){
        return repository.findByAuthorName(name);
    }
    public Book updatePrice(Book book){
        Book existingBook = repository.findByBookName(book.getBookName());
        existingBook.setPrice(book.getPrice());
        return repository.save(existingBook);
    }
}
