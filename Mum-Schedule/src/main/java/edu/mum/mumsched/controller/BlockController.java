package edu.mum.mumsched.controller;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.service.BlockService;
import edu.mum.mumsched.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RestController
public class BlockController {

    @Autowired
    BlockService blockService;

    @Autowired
    EntryService entryService;

    // get Block
    @RequestMapping(value="/getblock",method= RequestMethod.GET)
    public ModelAndView getCourses(){
        List<Block> allblocks=  blockService.getAllBlocks();
        //System.out.println("allblocks"+allblocks);
        ModelAndView mv= new ModelAndView();
        mv.addObject("blocks",allblocks);
        mv.setViewName("block");
    // get all entries

        List<Entry> entries=entryService.getAllEntries();
        mv.addObject("allentries",entries);

        return mv;
    }

    // add new block
    @RequestMapping(value = {"/addblock"}, method = RequestMethod.POST)
    public Block addEntry(@RequestBody Block blockObj, Model model) {
        //get entry and set entry
         Entry entry= entryService.findEntryByName(blockObj.getEntryName());
         System.out.println("entryfrom database"+entry);
         blockObj.setEntry(entry);
        ModelAndView blockmv= new ModelAndView();
        blockmv.addObject("blocks",blockObj);
        blockmv.setViewName("block");
        System.out.println("entry"+blockObj.getEntry());
        blockService.save(blockObj);
        return blockObj;

    }


    //delete block
    @Transactional
    @RequestMapping(value= {"/deleteblock"}, method= RequestMethod.POST)
    public @ResponseBody
    Block deleteCourse(@RequestBody Block block)
            throws ServletException, IOException {

        //delete entry using Ajax
        System.out.println(block);

        blockService.deleteBlockByName(block.getBlockName());
        return block;

    }

}
