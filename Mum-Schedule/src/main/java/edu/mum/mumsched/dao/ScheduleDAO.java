package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Course;
import edu.mum.mumsched.domain.Schedule;
import edu.mum.mumsched.domain.ScheduleStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleDAO extends CrudRepository<Schedule,Long> {
    Schedule findScheduleById(Long id);
    List<Schedule> findSchedulesByScheduleStatus(ScheduleStatus scheduleStatus);
    void deleteScheduleById(Long id);

//    default void addBlock(Block block){Schedule.addBlock(block);}
}
