package com.example.biblioteka21;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idbook;
    private String title;
    private String genre;
    private String publisher;
    private Integer pages;
    @ManyToOne
    private Author author;
    public Books() {
    }

    public Books(String title, String genre, String publisher, Integer pages) {
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.pages = pages;
    }

    public Books(Integer idbook, String title, String genre, String publisher, Integer pages) {
        this.idbook = idbook;
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.pages = pages;
    }

    public Books(String title, String genre, String publisher, Integer pages, Author author) {
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.pages = pages;
        this.author = author;
    }

    public Books(Integer idbook, String title, String genre, String publisher, Integer pages, Author author) {
        this.idbook = idbook;
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.pages = pages;
        this.author = author;
    }

    public Author getAuthor() {return author;}

    public void setAuthor(Author author) {this.author = author;}

    public Integer getIdbook() {return idbook;}

    public void setIdbook(Integer idbook) {this.idbook = idbook;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getGenre() {return genre;}

    public void setGenre(String genre) {this.genre = genre;}

    public String getPublisher() {return publisher;}

    public void setPublisher(String publisher) {this.publisher = publisher;}

    public Integer getPages() {return pages;}

    public void setPages(Integer pages) {this.pages = pages;}

    @Override
    public String toString() {
        return "Books{" +
                "idbook=" + idbook +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pages=" + pages +
                '}';
    }
}
