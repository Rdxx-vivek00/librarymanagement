package com.dev.viviek.librarymanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "title cannot be empty")
    private String title;

    @NotBlank(message = "Author cannot be empty")
    private String author;

 private boolean available=true;

    @ManyToMany(mappedBy = "borrowedBooks")
    private Set<User> users=new HashSet<User>();



}
