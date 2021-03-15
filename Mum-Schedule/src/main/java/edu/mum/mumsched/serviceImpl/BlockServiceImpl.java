package edu.mum.mumsched.serviceImpl;

import edu.mum.mumsched.dao.BlockDAO;
import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class BlockServiceImpl implements BlockService {


    @Autowired
    BlockDAO blockDao;

    @Override
    public Block save(Block block) {
        return  blockDao.save(block);
    }

    @Override
    public Block getBlockById(Long id) {
        return blockDao.findBlockById(id);
    }

    @Override
    public List<Block> getAllBlocks() {
        return blockDao.findAll();
    }

    @Override
    public Block getBlockByName(String blockName) {
        return blockDao.findBlockByBlockName(blockName);
    }

    @Override
    public Block getBlockByStartDate(LocalDate startDate) {
        return blockDao.findBlockByStartDate(startDate);
    }

    @Override
    public void deleteBlockById(Long id) {
        blockDao.deleteById(id);
    }

    @Override
    public void deleteBlockByName(String blockName) {
        blockDao.deleteBlockByBlockName(blockName);
    }
}
