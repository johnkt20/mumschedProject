package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Student;
import edu.mum.mumsched.domain.Student;
import edu.mum.mumsched.service.CourseService;
import edu.mum.mumsched.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value="/getstudents",method= RequestMethod.GET)
    public ModelAndView getStudents(){
        Iterable<Student> allStudents= studentService.getAllStudents();
        ModelAndView mv= new ModelAndView();
        mv.addObject("students",allStudents);
        mv.setViewName("student");


        return mv;
    }



    @RequestMapping(value= {"/addstudent"},method= RequestMethod.POST)
    public @ResponseBody
    Student addStudent(@RequestBody Student student)
            throws ServletException, IOException {
        // add courses using Ajax
        System.out.println("courseAdding"+student);
        studentService.save(student);
        ModelAndView mv= new ModelAndView();
        mv.addObject("courses",studentService.getAllStudents());
        return studentService.getStudentByName(student.getFirstName());

    }

    @RequestMapping(value= {"/deleteStudent"}, method= RequestMethod.POST)
    public @ResponseBody Student deleteStudent(@RequestBody Student student)
            throws ServletException, IOException {

        //delete course using Ajax
        System.out.println(student);
        studentService.deleteStudentById(student.getId());
        return student;

    }



}
