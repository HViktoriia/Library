package com.example.biblioteka21;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepo  extends JpaRepository<Books, Integer> {
    Object findAllBytitle(String title);

    void deleteByTitle(String title);
}
