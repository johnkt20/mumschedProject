package edu.mum.mumsched.service;

import edu.mum.mumsched.domain.Block;

import java.time.LocalDate;
import java.util.List;

public interface BlockService {


    public Block save(Block block);
    public Block getBlockById(Long id);
    public List<Block> getAllBlocks();
    public Block getBlockByName(String blockName);
    public Block getBlockByStartDate(LocalDate startDate);
    public void deleteBlockById(Long id);
    public void deleteBlockByName(String blockName);
}
