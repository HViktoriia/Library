package com.example.biblioteka21;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

    Object findAllByauthorname(String authornamek);
}
