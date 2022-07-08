package com.example.biblioteka21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ControllerAdvice
public class authorController {
    private BookRepo bookRepo;
    private AuthorRepo authorRepo;
    @Autowired
    public authorController(AuthorRepo authorRepo){this.authorRepo = authorRepo;}
    @RequestMapping("/addauthor")
    public String addauthor(){return "authoradder";}

    @RequestMapping("/authoradder")
    public String authoradder (@RequestParam("authorname") String authorname,
                               @RequestParam("authorsurname") String authorsurname,
                               Model model) throws Exception{
        Author author = new Author(authorname, authorsurname);
        System.out.println(author);
        authorRepo.save(author);
        model.addAttribute("author", author);
        return "showauthor";
    }
    @RequestMapping("/showauthor")
    public String showauthor(Model model){
        for(Author author : authorRepo.findAll()){
            System.out.println(author);
        }
        model.addAttribute("author", authorRepo.findAll());
        return "showauthor";
    }
    @RequestMapping("/kasujauthora")
    public String kasujauthora(@RequestParam("id") Integer id, Model model){
        authorRepo.deleteById(id);
        model.addAttribute("author", authorRepo.findAll());
        return "showauthor";
    }
    @RequestMapping("/wyszukajauthora")
    public String wyszukajauthora(@RequestParam("authorname") String authorname, Model model){
        model.addAttribute("author", authorRepo.findAllByauthorname(authorname));
        return "showauthor";
    }
    @RequestMapping("/updateauthor")
    public String updateauthor(
            @RequestParam("id") Integer id,
            @RequestParam("authorname") String authorname,
            @RequestParam("authorsurname") String authorsurname,
            Model model) throws Exception{
        Author author = new Author(id, authorname, authorsurname);
        System.out.println(author);
        authorRepo.save(author);
        model.addAttribute("author", author);
        return "showauthor";
    }
    @RequestMapping("/przekierujauthora")
    public String przekierujauthora(@RequestParam("id") Integer id, Model model) throws Exception{
        System.out.println(authorRepo.findById(id));
        model.addAttribute("author", authorRepo.findById(id));
        return "updateauthor";
    }
}
