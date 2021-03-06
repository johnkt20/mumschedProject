package edu.mum.mumsched.controller;

import com.google.gson.Gson;

import edu.mum.mumsched.domain.Course;
import edu.mum.mumsched.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class CourseController {
    Gson mapper = new Gson();
    @Autowired
    CourseService courseService;

    @RequestMapping(value="/getcourses",method=RequestMethod.GET)
public ModelAndView getCourses(){
        Iterable<Course> allcourses= courseService.getAllCourses();
        System.out.println("coursesFromDatabase"+ allcourses);
        System.out.println(allcourses.iterator());
        ModelAndView mv= new ModelAndView();
        mv.addObject("courses",allcourses);
        mv.setViewName("courses");

        System.out.println("helloooo");
        //model.addAttribute("newStudent",student);
        return mv;
}



    @RequestMapping(value= {"/addcourse"})
   public void addCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // add courses

System.out.println("addedd course");
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        try {
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } finally {
            reader.close();
        }

        String json = sb.toString();
       Course course = mapper.fromJson(json, Course.class);
       courseService.save(course);

        System.out.println("addedCourese" + course);

        PrintWriter out = response.getWriter();
        System.out.println("productController"+course);
        out.print(mapper.toJson(course));


    }

    @RequestMapping(value= {"/deleteCourse"}, method= RequestMethod.POST)
    public void deleteCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //delete course

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } finally {
            reader.close();
        }

        String json = sb.toString();
        Course course = mapper.fromJson(json, Course.class);
        courseService.deleteCourseById(course.getId());
        System.out.println("deletecourse" + course);

        PrintWriter out = response.getWriter();
        out.print(mapper.toJson(course));
    }




}
