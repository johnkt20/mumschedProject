package edu.mum.mumsched.controller;


import edu.mum.mumsched.domain.Course;
import edu.mum.mumsched.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value="/getcourses",method=RequestMethod.GET)
public ModelAndView getCourses(){
        Iterable<Course> allcourses= courseService.getAllCourses();
        ModelAndView mv= new ModelAndView();
        mv.addObject("courses",allcourses);
        mv.setViewName("courses");


        return mv;
}



    @RequestMapping(value= {"/addcourse"},method= RequestMethod.POST)
   public @ResponseBody Course addCourse(@RequestBody Course course, Model model)
            throws ServletException, IOException {
       // add courses using Ajax
        System.out.println("check addingcourse");
        System.out.println("Added Course"+course);
        System.out.println("courseprerequesit"+course.getPrerequisites());

        courseService.save(course);
        ModelAndView mv= new ModelAndView();
        mv.addObject("courses",courseService.getAllCourses());


       // preq.addObject("preq_courses",)
        return courseService.getCourseByName(course.getCourseName());

    }

    @RequestMapping(value= {"/deleteCourse"}, method= RequestMethod.POST)
    public @ResponseBody Course deleteCourse(@RequestBody Course course)
            throws ServletException, IOException {

        //delete course using Ajax
        System.out.println(course);
        courseService.deleteCourseById(course.getId());
        return course;

    }


    @RequestMapping(value= {"/updatecourse"}, method= RequestMethod.POST)
    public @ResponseBody Course updateCourse(@RequestBody Course course)
            throws ServletException, IOException {

        //update course using Ajax
        System.out.println("courseupdating"+course+"preqreq:"+course.getPrerequisites().get(0));
        Course course1=courseService.getCourseByName(course.getCourseName());

        course1.setCourseName(course.getCourseName());
        course1.setCourseCode(course.getCourseCode());
        course1.setPrerequisites(course.getPrerequisites());
        System.out.println("courseupdating2"+course1+"preqreq2:"+course1.getPrerequisites().get(0));
       courseService.save(course1);
       System.out.println("coursefrom database"+ courseService.getCourseByID(course.getId()));
        return course1;

    }


}
