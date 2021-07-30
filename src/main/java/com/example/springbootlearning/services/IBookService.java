package com.example.springbootlearning.services;

import com.example.springbootlearning.models.Book;

import java.util.List;

public interface IBookService {
    List<Book> get();
    Book get(int id);
    void create(Book book);
    void update(Book book);
    void delete(int id);
}
