package com.dev.viviek.librarymanagement.controllers;

import com.dev.viviek.librarymanagement.entity.Book;
import com.dev.viviek.librarymanagement.service.BookService;
import com.dev.viviek.librarymanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book)
    {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id)
    {
        bookService.deleteBook(id);
    }
}
