package com.dev.viviek.librarymanagement.service;

import com.dev.viviek.librarymanagement.entity.Book;
import com.dev.viviek.librarymanagement.entity.User;
import com.dev.viviek.librarymanagement.repository.BookRepo;
import com.dev.viviek.librarymanagement.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final BookRepo bookRepo;

    public User registerUser(User user)
    {
        return userRepo.save(user);
    }

    public String borrowBook(Long user_id,Long book_id)
    {
        Optional<User> userOpt=userRepo.findById(user_id);
        Optional<Book> bookOpt=bookRepo.findById(book_id);

        if(userOpt.isPresent() && bookOpt.isPresent())
        {
            User user=userOpt.get();
            Book book=bookOpt.get();

            if(!book.isAvailable())
                return "Book is already borrowed:";

            user.getBorrowedBooks().add(book);
            book.setAvailable(false);

            userRepo.save(user);
            bookRepo.save(book);
        }
        return "user or book not found";

    }

}
