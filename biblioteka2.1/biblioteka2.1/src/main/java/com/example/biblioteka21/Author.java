package com.example.biblioteka21;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idauthor;
    private String authorname;
    private String authorsurname;
    @OneToMany
    private List<Books> books;

    public Author() {
    }

    public Integer getIdauthor() {
        return idauthor;
    }

    public void setIdauthor(Integer idauthor) {
        this.idauthor = idauthor;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getAuthorsurname() {
        return authorsurname;
    }

    public void setAuthorsurname(String authorsurname) {
        this.authorsurname = authorsurname;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public Author(Integer idauthor, String authorname, String authorsurname) {
        this.idauthor = idauthor;
        this.authorname = authorname;
        this.authorsurname = authorsurname;
    }

    public Author(String authorname, String authorsurname) {
        this.authorname = authorname;
        this.authorsurname = authorsurname;
    }

    public Author(String authorname, String authorsurname, List<Books> books) {
        this.authorname = authorname;
        this.authorsurname = authorsurname;
        this.books = books;
    }

    public Author(Integer idauthor, String authorname, String authorsurname, List<Books> books) {
        this.idauthor = idauthor;
        this.authorname = authorname;
        this.authorsurname = authorsurname;
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "idauthor=" + idauthor +
                ", authorname='" + authorname + '\'' +
                ", authorsurname='" + authorsurname + '\'' +
                ", books=" + books +
                '}';
    }
}
