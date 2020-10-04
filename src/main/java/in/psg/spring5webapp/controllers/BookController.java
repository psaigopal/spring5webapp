package in.psg.spring5webapp.controllers;

/*
Created by Saigopal 
for project spring5webapp
04-10-2020 13:45
*/

import in.psg.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

   private final BookRepository bookRepository;

   public BookController(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
   }

   @RequestMapping("/books")
   public String getBooks(Model model){
      model.addAttribute("books",bookRepository.findAll());
      return "books";
   }
}
