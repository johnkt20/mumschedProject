package edu.mum.mumsched.service;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Schedule;
import edu.mum.mumsched.domain.ScheduleStatus;

import java.util.List;

public interface ScheduleService {

    void save(Schedule schedule);
    Schedule getScheduleById(Long id);
    Iterable<Schedule> getAllSchedules();
    void deleteScheduleById(Long id);
    void addBlock(Long scheduleId, Block block);
    void addBlocks(Long scheduleId, List<Block> blocks);
    List<Schedule> getAllSchedulesWthStatus(ScheduleStatus scheduleStatus);
}
