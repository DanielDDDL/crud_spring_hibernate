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
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author daniel
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @Autowired
    private TagService tagService;
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addBookPage() {
                
        List<Tag> tags = tagService.getTags();
        
        ModelAndView modelAndView = new ModelAndView("form-book");
        modelAndView.addObject("book", new Book());
        modelAndView.addObject("tags", tags);

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addBookProcess(@ModelAttribute Book book) {

        bookService.addBook(book);
        return new ModelAndView("redirect:/book/add");
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editBookPage(@PathVariable Integer id) {
                
        Book book = bookService.getBook(id);        
        List<Tag> tags = tagService.getTags();
        
        ModelAndView modelAndView = new ModelAndView("form-book-edit");
        modelAndView.addObject("book",book);
        modelAndView.addObject("tags",tags);
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editBookProcess(@ModelAttribute Book book, @PathVariable Integer id){
                
        bookService.updateBook(book);
        return new ModelAndView("redirect:/index");   
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable Integer id){
        
        bookService.deleteBook(id);        
        return new ModelAndView("redirect:/index");
    }
    
}
