package com.example.springbootlearning.services;

import com.example.springbootlearning.exceptions.RecordNotFoundException;
import com.example.springbootlearning.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBookService {
    private final List<Book> books;

    public BookService() {
        this.books = new ArrayList<>();

        books.add(new Book(101, "Learning Java", 500, 250.25, "John Doe", "AW"));
        books.add(new Book(102, "Learning SQL", 700, 852.25, "John Doe", "AW"));
        books.add(new Book(103, "Learning Spring Boot", 1020, 356.28, "John Doe", "AW"));
    }

    @Override
    public List<Book> get() {
        return books;
    }

    @Override
    public Book get(int id) {
        for (Book b: books) {
            if (b.getId() == id) {
                return b;
            }
        }

        throw new RecordNotFoundException("Could not find the book with id: " + id);
    }

    @Override
    public void create(Book book) {
        books.add(book);
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(int id) {
        Book book = null;
        for (Book b: books) {
            if (b.getId() == id) {
                book = b;
            }
        }

        if (book != null) {
            books.remove(book);
        } else {
            throw new RecordNotFoundException("Could not find the book with id: " + id);
        }
    }
}
