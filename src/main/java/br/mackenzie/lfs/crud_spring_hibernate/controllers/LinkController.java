/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.lfs.crud_spring_hibernate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dias
 */
@Controller
public class LinkController {
    
    @RequestMapping(value="/")
    public ModelAndView mainPage(){
        return new ModelAndView("home");
    }
    
    @RequestMapping(value="/index")
    public ModelAndView indexPage(){
        return new ModelAndView("home");
    }
    
}
