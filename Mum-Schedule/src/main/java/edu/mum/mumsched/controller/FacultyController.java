package edu.mum.mumsched.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FacultyController {

    @RequestMapping(value={"/getfacultyprofile"},method= RequestMethod.GET)
    public ModelAndView getFacultyProfile(){
        ModelAndView mv= new ModelAndView("facultyprofile");
        return mv;
    }
}
