package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.*;
import edu.mum.mumsched.service.CourseService;
import edu.mum.mumsched.service.EntryService;
import edu.mum.mumsched.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@SessionAttributes({"allsections","scheid"})
@RestController
public class ScheduleController {
// check if schedule is generated or not
boolean checkSchedule=false;

    @Autowired
    ScheduleService scheduleService;
    @Autowired
    EntryService entryService;
    @Autowired
    CourseService courseService;
    // get Block
    @RequestMapping(value="/getschedule",method= RequestMethod.GET)
    public ModelAndView getCourses(){
       Iterable<Schedule> allschedules=  scheduleService.getAllSchedules();
       List<Entry> allentries= entryService.getAllEntries();
       for(Schedule s:allschedules){
           System.out.println("enrtry:"+s.getEntry());
       }

        //System.out.println("allblocks"+allblocks);
        ModelAndView mv= new ModelAndView();
        mv.addObject("allschedules",allschedules);
        mv.addObject("allentries",allentries);
        mv.setViewName("schedule");
        // get all entries


        return mv;
    }


    @RequestMapping(value = {"/addschedule"}, method = RequestMethod.POST)
    public Schedule addEntry(@RequestBody Schedule scheduleObj, Model model) {

        // setting entry and schedule
        String entryname=scheduleObj.getEntry().getEntryName();
        Entry entry=entryService.findEntryByName(entryname);
       scheduleObj.getEntry().setId(entry.getId());
        System.out.println("entryname:"+scheduleObj.getEntry().getEntryName());
        System.out.println("status"+scheduleObj.getScheduleStatus().toString());
       scheduleService.save(scheduleObj);
        return scheduleObj;

    }

    //delete Schedule
    @Transactional
    @RequestMapping(value= {"/deleteschedule"}, method= RequestMethod.POST)
    public @ResponseBody
    Schedule deleteCourse(@RequestBody Schedule schedule)
            throws ServletException, IOException {

        //delete entry using Ajax
        System.out.println("id"+schedule.getId());
        Long id=(Long)schedule.getId();
        scheduleService.deleteScheduleById(id);
        return schedule;

    }


    @RequestMapping(value= {"/updateschedule"}, method= RequestMethod.POST)
    public @ResponseBody
   Schedule updateCourse(@RequestBody Schedule schedule)
            throws ServletException, IOException {

        //update course using Ajax
        System.out.println("schedulepdating");
       Schedule schedule1=scheduleService.getScheduleById(schedule.getId());
       schedule1.setScheduleStatus(schedule.getScheduleStatus());

     scheduleService.save( schedule1);
        return schedule1;

    }

@RequestMapping(value={"/generateschedule"}, method=RequestMethod.POST)
    public @ResponseBody  Schedule generateSchedule(@RequestBody Schedule scheduleObj, Model model,HttpSession session){


        System.out.println("generate schedulein");
        Schedule schedule1=scheduleService.getScheduleById(scheduleObj.getId());
        List<Block> blocks=schedule1.getEntry().getBlocks();
        List<Section> section= new ArrayList<>();

        for(Block block:blocks){
            section.addAll(block.getSections());
        }


       //List<Course> course=new ArrayList<>();
    //for(Section sections: section){
      //  course.add(sections.getCourse());
   // }
        System.out.println("cours:"+ section);
        session.setAttribute("allsections", section);
        session.setAttribute("scheid",scheduleObj.getId());
       //model.addAttribute("allcoursess",cours);

        return scheduleObj;
    }
    @RequestMapping(value="/getmumsched",method= RequestMethod.GET)
    public ModelAndView getAllSchedule(Model model,HttpSession session){

        if(session.getAttribute("scheid")!=null){
            Long id=(Long)session.getAttribute("scheid");
            Schedule schedule1=scheduleService.getScheduleById(id);
            List<Block> blocks=schedule1.getEntry().getBlocks();
            List<Section> section= new ArrayList<>();
            for(Block block:blocks){

                section.addAll(block.getSections());
            }
            System.out.println("check in set attrivute"+section);
            session.setAttribute("allsections",section);
            model.addAttribute("allsections",section);
            for(Section sec:section){
                System.out.println("courseinschedule"+sec.getCourse().getCourseName());
            }
        }
        ModelAndView mv=new ModelAndView("mumsched");


        return mv;
    }
}
