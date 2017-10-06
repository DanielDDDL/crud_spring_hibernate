
package br.mackenzie.lfs.crud_spring_hibernate.controllers;

import br.mackenzie.lfs.crud_spring_hibernate.exceptions.BookNotFoundException;
import br.mackenzie.lfs.crud_spring_hibernate.model.Book;
import br.mackenzie.lfs.crud_spring_hibernate.model.Tag;
import br.mackenzie.lfs.crud_spring_hibernate.model.request.TagPropertyEditor;
import br.mackenzie.lfs.crud_spring_hibernate.services.BookService;
import br.mackenzie.lfs.crud_spring_hibernate.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import org.springframework.validation.BindingResult;

/**
 *
 * @author Dias
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
    public ModelAndView addBookProcess(@ModelAttribute @Valid Book book, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("form-book");
            modelAndView.addObject("book", book);
            modelAndView.addObject("tags", tagService.getTags());
            return modelAndView;

        }
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
    public ModelAndView editBookProcess(@ModelAttribute @Valid Book book, BindingResult bindingResult) throws BookNotFoundException {

        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("form-book-edit");
            modelAndView.addObject("book", book);
            modelAndView.addObject("tags", tagService.getTags());
            return modelAndView;
        }

        bookService.updateBook(book);
        return new ModelAndView("redirect:/index");   
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable Integer id) throws BookNotFoundException {
        
        bookService.deleteBook(id);        
        return new ModelAndView("redirect:/index");
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Tag.class, new TagPropertyEditor(tagService));
    }
    
}
