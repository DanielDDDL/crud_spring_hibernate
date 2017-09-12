
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
        return new ModelAndView("redirect:/tag/add");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editTagPage(@PathVariable Integer id) {
        
        Tag tag = tagService.getTag(id);
        
        ModelAndView modelAndView = new ModelAndView("form-tag-edit");
        modelAndView.addObject("tag",tag);
        
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editTagProcess(@ModelAttribute Tag tag, @PathVariable Integer id){
        
        tagService.updateTag(tag);
        return new ModelAndView("redirect:/index");   
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteTag(@PathVariable Integer id){
        
        tagService.deleteTag(id);
        return new ModelAndView("redirect:/index");
    }
    
    
}
