package io.github.ndimovt.bookstore.controller;

import io.github.ndimovt.bookstore.entity.Book;
import io.github.ndimovt.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class BookController {
    @Autowired
    private BookService service;
    @PostMapping("/add")
    public Book add(@RequestBody Book book){
        return service.add(book);
    }
    @GetMapping("/printAll")
    public List<Book> printAll(){
        return service.getAll();
    }
    @GetMapping("/find/{name}")
    public ArrayList<Book> find(@PathVariable String name){
        return service.byAuthor(name);
    }
    @PutMapping("/updatePrice")
    public Book update(@RequestBody Book book){
        return service.updatePrice(book);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "Product removed successfully";
    }

}
