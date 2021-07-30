package com.example.springbootlearning.controllers;

import com.example.springbootlearning.exceptions.RecordNotFoundException;
import com.example.springbootlearning.models.Book;
import com.example.springbootlearning.services.IBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    //  GET (all)
    @GetMapping
    public ResponseEntity<List<Book>> get() {
        return ResponseEntity.ok(bookService.get());
    }

    //  GET (id)
    @GetMapping("{id}")
    public ResponseEntity<Book> get(@PathVariable int id) {
        return ResponseEntity.ok(bookService.get(id));
    }

    //  POST
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Book book) {
        System.out.println(book.getTitle());
        bookService.create(book);
        return ResponseEntity.ok().build();
    }

    //  PUT
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Book book) {
        System.out.println(book.getTitle());
        bookService.update(book);
        return ResponseEntity.ok().build();
    }

    //  DELETE (id)
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(RecordNotFoundException exception) {
        return ResponseEntity.badRequest().body("RNF: " + exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception exception) {
        return ResponseEntity.badRequest().body("GE: " + exception.getMessage());
    }
}
