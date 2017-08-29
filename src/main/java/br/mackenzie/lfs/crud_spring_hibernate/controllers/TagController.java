/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.lfs.crud_spring_hibernate.controllers;

    import br.mackenzie.lfs.crud_spring_hibernate.model.Tag;
    import br.mackenzie.lfs.crud_spring_hibernate.services.TagService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dias
 */
@Controller
@RequestMapping(value = "/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addTagPage() {
        
        ModelAndView modelAndView = new ModelAndView("form-tag");
        modelAndView.addObject("tag", new Tag());

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addTagProcess(@ModelAttribute Tag tag) {

        tagService.addTag(tag);

        ModelAndView modelAndView = new ModelAndView("form-tag");
        String message = "Tag was successfully added.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editTagPage(@PathVariable Integer id) {
        
        Tag tag = tagService.getTag(id);
        
        ModelAndView modelAndView = new ModelAndView("form-tag");
        modelAndView.addObject("tag",tag);
        
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public ModelAndView editTagProcess(@ModelAttribute Tag tag, @PathVariable Integer id){
        
        tagService.updateTag(tag);
        String message = "Tag updated successfully.";
        
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("message",message);
        
        return modelAndView;    
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteTag(@PathVariable Integer id){
        
        tagService.deleteTag(id);
        return new ModelAndView("redirect:/index");
    }
    
    
}
