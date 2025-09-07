package com.dev.viviek.librarymanagement.service;

import com.dev.viviek.librarymanagement.entity.Book;
import com.dev.viviek.librarymanagement.repository.BookRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {


    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo)
    {
        this.bookRepo=bookRepo;
    }

    public List<Book> getAllBooks()
    {
        return bookRepo.findAll();
    }

    public Book addBook(Book book)
    {
        return bookRepo.save(book);
    }

    public void deleteBook(Long id)
    {
        bookRepo.deleteById(id);
    }


}
