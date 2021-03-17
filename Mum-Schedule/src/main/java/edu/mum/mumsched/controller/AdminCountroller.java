package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class AdminCountroller {

    @RequestMapping(value = "/adminpanel", method = RequestMethod.GET)
    public ModelAndView showAdminPanel() {

        ModelAndView mv= new ModelAndView();
        mv.setViewName("AdminPanel.html");
        return mv;
    }

    @RequestMapping(value = "/getmainpage", method = RequestMethod.GET)
    public ModelAndView showMainPanel() {

        ModelAndView mv= new ModelAndView();
        mv.setViewName("mainpage");
        return mv;
    }

}