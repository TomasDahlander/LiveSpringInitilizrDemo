package com.example.demo.controllers;

import models.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repos.BookDAO;

import java.util.List;

// CRUD = create, read, update, delete

@RestController
public class BookServerController {

    BookDAO db = new BookDAO();
    List<Book> books = db.getAllBooks();

    @RequestMapping("/books")
    public List<Book> books(){
        return books;
    }
}
