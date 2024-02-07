package io.github.ndimovt.bookstore.service;

import io.github.ndimovt.bookstore.entity.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Populate {
    private static Connection connection;
    static {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstorev2", "root", "sheeuser123456@");
        }catch (SQLException sqe ){
            sqe.printStackTrace();
        }
    }

    public static ArrayList<Book> insert() {
        ArrayList<Book> populated = new ArrayList<>();
        try (PreparedStatement pst = connection.prepareStatement("call bookstorev2.populate()");
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()){
                Book book = new Book(rs.getString("book_name"), rs.getString("author_name"), rs.getDouble("price"));
                populated.add(book);
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
        }
        return populated;
    }
}
