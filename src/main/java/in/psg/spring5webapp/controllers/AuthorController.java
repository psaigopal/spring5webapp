package in.psg.spring5webapp.controllers;

/*
Created by Saigopal 
for project spring5webapp
04-10-2020 14:39
*/

import in.psg.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

   private final AuthorRepository authorRepository;

   public AuthorController(AuthorRepository authorRepository) {
      this.authorRepository = authorRepository;
   }


   @RequestMapping("/authors")
   public String getAuthors(Model model){
      model.addAttribute("authors",authorRepository.findAll());
      return "authors/author-list";
   }
}
