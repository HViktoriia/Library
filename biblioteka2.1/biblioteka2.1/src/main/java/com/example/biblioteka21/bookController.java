package com.example.biblioteka21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@ControllerAdvice
public class bookController {
    private BookRepo bookRepo;
    private AuthorRepo authorRepo;
    @Autowired
    public bookController(BookRepo bookRepo, AuthorRepo authorRepo){
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;}

    @RequestMapping("/addbook")
    public String addbook() {return "bookadder";}

    @RequestMapping("/bookadder")
    public String bookadder(@RequestParam("title") String title,
                            @RequestParam("genre") String genre,
                            @RequestParam("publisher") String publisher,
                            @RequestParam("pages") Integer pages,
                            @RequestParam("author") Author author ,Model model)
        throws Exception{
        List<Author> authors = new ArrayList<>();
        model.addAttribute("author", author);
        List<Author> authors1= authorRepo.findAll();
        model.addAttribute("author", authors);
        Books books = new Books(title, genre, publisher, pages, author);
        System.out.println(books);
        bookRepo.save(books);
        model.addAttribute("books", books);
        return "noweDany";
    }
    @RequestMapping("/showbooks")
    public String showbooks(Model model){
        for (Books books : bookRepo.findAll()){
            System.out.println(books);
        }
        model.addAttribute("books", bookRepo.findAll());
        return "showbooks";
    }
    @RequestMapping("/kasuj")
    public String kasuj(@RequestParam("id") Integer id, Model model){
    //    bookRepo.deleteById(id);
        bookRepo.deleteById(id);
        model.addAttribute("books", bookRepo.findAll());
        return "showbooks";
    }

    @RequestMapping("/wyszukaj")
    public String wyszukaj (@RequestParam("title") String title, Model model){
        model.addAttribute("books", bookRepo.findAllBytitle(title));
        return "showbooks";
    }

    @RequestMapping("/updatebook")
    public String aktualizuj(
            @RequestParam("id") Integer id,
            @RequestParam("title") String title,
            @RequestParam("genre") String genre,
            @RequestParam("publisher") String publisher,
            @RequestParam("pages") Integer pages, Model model)
        throws Exception {
        Books books = new Books(id, title, genre, publisher, pages);
        System.out.println(books);
        bookRepo.save(books);
        model.addAttribute("books", books);
        return "noweDany";
    }
    @RequestMapping("/przekieruj")
    public String przekieruj(@RequestParam("id") Integer id, Model model) throws Exception{
        System.out.println(bookRepo.findById(id));
        model.addAttribute("books", bookRepo.findById(id));
        return "updatebook";
    }
}
