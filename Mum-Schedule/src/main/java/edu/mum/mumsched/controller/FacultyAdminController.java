package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Faculty;
import edu.mum.mumsched.domain.Student;
import edu.mum.mumsched.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;

@RestController
public class FacultyAdminController {

@Autowired
FacultyService facultyService;

    @RequestMapping(value="/getfaculty",method= RequestMethod.GET)
    public ModelAndView getFaculties(){
        Iterable<Faculty> allfaculties= facultyService.getAllFaculty();
        ModelAndView mv= new ModelAndView();
        mv.addObject("faculties",allfaculties);
        mv.setViewName("faculty");


        return mv;
    }


    @RequestMapping(value= {"/addfaculty"},method= RequestMethod.POST)
    public @ResponseBody
   Faculty addFaculty(@RequestBody Faculty faculty)
            throws ServletException, IOException {
        // add courses using Ajax
        System.out.println("courseAdding"+faculty);
        facultyService.save(faculty);
        ModelAndView mv= new ModelAndView();
        mv.addObject("courses",facultyService.getAllFaculty());
        return facultyService.getFacultyByName(faculty.getFirstName());

    }


    @RequestMapping(value= {"/deletefaculty"}, method= RequestMethod.POST)
    public @ResponseBody Faculty deleteFaculty(@RequestBody Faculty faculty)
            throws ServletException, IOException {

        //delete course using Ajax
        System.out.println("deleting faculty Id"+faculty.getId());
        System.out.println(faculty);
       facultyService.deleteFacultyById(faculty.getId());
        return faculty;

    }

    @RequestMapping(value= {"/updatefaculty"}, method= RequestMethod.POST)
    public @ResponseBody
    Faculty updateStudent(@RequestBody Faculty faculty)
            throws ServletException, IOException {

        //update course using Ajax
        System.out.println("courseupdating"+faculty);
        Faculty update_faculty= facultyService.getFacultyById(faculty.getId());
        update_faculty.setFirstName(faculty.getFirstName());
        update_faculty.setLastName(faculty.getLastName());

        facultyService.save(update_faculty);
        System.out.println("coursefrom database"+ facultyService.getFacultyById(update_faculty.getId()));
        return faculty;

    }
}
