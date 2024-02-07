package io.github.ndimovt.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book_information")
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String bookName;
    private String authorName;
    //@JsonProperty("bookPrice")
    private double price;   //if variable name is different then object property in js object(eg: js bookPrice, here price) it is req to have JsonProperty

    public Book(String bookName, String authorName, double price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
    }

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
