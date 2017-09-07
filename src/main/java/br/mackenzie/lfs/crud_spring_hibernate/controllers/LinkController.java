/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.lfs.crud_spring_hibernate.controllers;

import br.mackenzie.lfs.crud_spring_hibernate.model.Book;
import br.mackenzie.lfs.crud_spring_hibernate.model.Tag;
import br.mackenzie.lfs.crud_spring_hibernate.services.BookService;
import br.mackenzie.lfs.crud_spring_hibernate.services.TagService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dias
 */
@Controller
public class LinkController {
    
    @Autowired
    private TagService tagService;
    
    @Autowired
    private BookService bookService;
    
    @RequestMapping(value="/")
    public ModelAndView mainPage(){
        return gettingInitialInfo();
    }
    
    @RequestMapping(value="/index")
    public ModelAndView indexPage(){
        return gettingInitialInfo();
    }
    
    private ModelAndView gettingInitialInfo(){
        
        List<Tag> tags = tagService.getTags();
        List<Book> books = bookService.getBooks();
        
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("books", books);
        modelAndView.addObject("tags", tags);
        
        return modelAndView;
        
    }
    
}
