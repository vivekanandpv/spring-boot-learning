package com.example.springbootlearning.models;

public class Book {
    private final int id;
    private final String title;
    private final int nPages;
    private final double price;
    private final String author;
    private final String publisher;

    public Book(int id, String title, int nPages, double price, String author, String publisher) {
        this.id = id;
        this.title = title;
        this.nPages = nPages;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getnPages() {
        return nPages;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }
}
