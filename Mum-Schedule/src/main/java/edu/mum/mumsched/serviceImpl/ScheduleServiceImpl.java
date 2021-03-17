package edu.mum.mumsched.serviceImpl;

import edu.mum.mumsched.dao.EntryDAO;
import edu.mum.mumsched.dao.ScheduleDAO;
import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Schedule;
import edu.mum.mumsched.domain.ScheduleStatus;
import edu.mum.mumsched.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleDAO scheduleDoa;

    @Autowired
    EntryDAO entryDao;

    @Override
    public void save(Schedule schedule) {
        scheduleDoa.save(schedule);
    }

    @Override
    public Schedule getScheduleById(Long id) {
        return scheduleDoa.findScheduleById(id);
    }

    @Override
    public Iterable<Schedule> getAllSchedules() {
        return scheduleDoa.findAll();
    }


    @Override
    public void deleteScheduleById(Long id) {
        scheduleDoa.deleteScheduleById(id);
    }

    @Override
    public void addBlock(Long scheduleId, Block block) {
        scheduleDoa.findScheduleById(scheduleId).addBlock(block);
    }

    @Override
    public void addBlocks(Long scheduleId, List<Block> blocks) {
        scheduleDoa.findScheduleById(scheduleId).addBlocks(blocks);
    }

    @Override
    public List<Schedule> getAllSchedulesWthStatus(ScheduleStatus scheduleStatus) {
        return scheduleDoa.findSchedulesByScheduleStatus(scheduleStatus);
    }
}
