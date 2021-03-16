package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Course;
import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.domain.Section;
import edu.mum.mumsched.service.BlockService;
import edu.mum.mumsched.service.CourseService;
import edu.mum.mumsched.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class SectionController {
      @Autowired
    SectionService sectionService;
    @Autowired
      CourseService courseService;
    @Autowired
    BlockService blockService;
    // get Section
    @RequestMapping(value="/getsection",method= RequestMethod.GET)
    public ModelAndView getSection(){
        List<Section> allsections=  sectionService.getAllSection();

        ModelAndView mv= new ModelAndView();
        mv.addObject("allsections",allsections);
        mv.setViewName("section");
        // get all entries

        Iterable<Course> courses=courseService.getAllCourses();

        List<Block> blocks = blockService.getAllBlocks();
        //System.out.println("courses"+courses);
        mv.addObject("allcourses",courses);
        mv.addObject("allblocks",blocks);

        return mv;
    }

    // add new section

    @RequestMapping(value = {"/addsection"}, method = RequestMethod.POST)
    public Section addSection(@RequestBody Section sectionObj, Model model) {
        //get entry and set entry

     Course course1=courseService.getCourseByName(sectionObj.getCourse().getCourseName());
     sectionObj.getCourse().setId(course1.getId());
     Block block1= sectionObj.getBlock();
     System.out.println("inside section");

    Block block2= blockService.getBlockByName(block1.getBlockName());
    sectionObj.getBlock().setId(block2.getId());

        ModelAndView blockmv= new ModelAndView();
        blockmv.addObject("sections",sectionObj);
        blockmv.setViewName("section");

       Section section= sectionService.SaveSection(sectionObj);
       System.out.println("savedsection"+section.getSectionName());

        return  sectionObj;

    }

    @RequestMapping(value= {"/deletesection"}, method= RequestMethod.POST)
    public @ResponseBody Section deleteSection(@RequestBody Section section)
            throws ServletException, IOException {
        //delete course using Ajax
        System.out.println("sectionDeleteing");
        System.out.println(section);
       Section section_01=sectionService.findSectionByClassRoom(section.getClassRoom());
       sectionService.deleteSectionById(section_01.getId());
        return section;

    }

}
