package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Entry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class StudentController {

    @RequestMapping(value={"/getstudentprofile"},method= RequestMethod.GET)
    public ModelAndView getStudentProfile(){
        ModelAndView mv= new ModelAndView("studentprofile");
        return mv;
    }

}
