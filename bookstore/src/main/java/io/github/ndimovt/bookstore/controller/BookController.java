package io.github.ndimovt.bookstore.controller;

import io.github.ndimovt.bookstore.entity.Book;
import io.github.ndimovt.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BookController {
    @Autowired
    private BookService service;
    @PostMapping("/add")
    public Book add(@RequestBody Book book){
        return service.addBook(book);
    }
    @GetMapping("/printAll")
    public List<Book> printAll(){
        return service.getAllBooks();
    }
    @GetMapping("/find/{name}")
    public Book find(@PathVariable String name){
        return service.getBook(name);
    }
    @PutMapping("/updatePrice")
    public Book update(@RequestBody Book book){
        return service.updatePrice(book);
    }
    @DeleteMapping("/delete/{name}")
    public String delete(@PathVariable String name){
        service.delete(name);
        return "Product removed successfully";
    }

}
