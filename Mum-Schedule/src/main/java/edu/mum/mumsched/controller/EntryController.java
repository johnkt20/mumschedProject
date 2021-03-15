package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Course;
import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.domain.EntryType;
import edu.mum.mumsched.domain.Student;
import edu.mum.mumsched.service.EntryService;
import edu.mum.mumsched.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EntryController {

    @Autowired
    EntryService entryService;


// get Entry
    @RequestMapping(value="/getentry",method=RequestMethod.GET)
    public ModelAndView getCourses(){
        List<Entry> allentries= entryService.getAllEntries();
        System.out.println("allentryies"+allentries);
        ModelAndView mv= new ModelAndView();
        mv.addObject("entries",allentries);
        mv.setViewName("entry");

        return mv;
    }

    // add new Entry
    @RequestMapping(value = {"/addentry"}, method = RequestMethod.POST)
    public Entry addEntry(@RequestBody Entry entryObj, Model model) {
        ModelAndView entrymv= new ModelAndView();
        System.out.println(entryObj);

        // update entry name
            entryObj.setEntryName(entryObj.getEntryName()+entryObj.getStartDate().getYear());
            entrymv.addObject("entries",entryObj);
            entrymv.setViewName("entry");
            entryService.save(entryObj);
            return entryObj;

    }


// delete entry
@RequestMapping(value= {"/deleteentry"}, method= RequestMethod.POST)
public @ResponseBody Entry deleteCourse(@RequestBody Entry entry)
        throws ServletException, IOException {

    //delete entry using Ajax
    System.out.println(entry);
  Entry entry01=  entryService.findEntryByName(entry.getEntryName());
  entryService.deleteEntry(entry01.getId());
    return entry;

}

    @RequestMapping(value= {"/updateentry"}, method= RequestMethod.POST)
    public @ResponseBody Entry updateCourse(@RequestBody Entry entry)
            throws ServletException, IOException {

        //update course using Ajax
        System.out.println("entry"+entry);
      Entry entry1=entryService.findEntryByName(entry.getEntryName());

        entry1.setFppNumber(entry.getFppNumber());
        entry1.setMppNumber(entry.getMppNumber());

        entryService.save(entry1);

        return entry1;

    }




}
