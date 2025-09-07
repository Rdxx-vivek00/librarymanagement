package com.dev.viviek.librarymanagement.controllers;

import com.dev.viviek.librarymanagement.entity.User;
import com.dev.viviek.librarymanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @PostMapping("/register")
    public User register(User user)
    {
        return userService.registerUser(user);
    }

    @PostMapping("/{user_id}/borrow/{book_id}")
    public String borrowBook(@PathVariable Long user_id,@PathVariable Long book_id)
    {
       return  userService.borrowBook(user_id,book_id);
    }

}
