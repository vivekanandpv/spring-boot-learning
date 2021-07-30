package com.example.springbootlearning.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sample")
public class SampleController {
    //  GET
    @GetMapping
    public ResponseEntity<String> get(@RequestParam(required = false) int year) {
        return ResponseEntity.ok("GET: Good morning! " + year);
    }

    @GetMapping("{year}/{id}/{city}")
    public ResponseEntity<String> get(@PathVariable int id, @PathVariable int year, @PathVariable String city) {
        return ResponseEntity.ok("GET: Good morning! " + id + " " + city + " " + year);
    }



    //  POST
    @PostMapping
    public ResponseEntity<String> post() {
        return ResponseEntity.ok("POST: Good morning");
    }

    //  PUT

    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.ok("PUT: Good morning");
    }

    //  DELETE
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("DELETE: Good morning");
    }

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(Exception exception) {
        return ResponseEntity.badRequest().body("Handled exception in the controller");
    }
}
