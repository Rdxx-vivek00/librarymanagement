package com.dev.viviek.librarymanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="name cannot be blank")
    private String name;

    @Email(message = "Enter a valid email")
    private String email;

    @ManyToMany
    @JoinTable(name = "user_books",
                joinColumns = @JoinColumn(name="user_id"),
                 inverseJoinColumns = @JoinColumn(name = "book_id")
                  )
    private Set<Book> borrowedBooks=new HashSet<>();
}
