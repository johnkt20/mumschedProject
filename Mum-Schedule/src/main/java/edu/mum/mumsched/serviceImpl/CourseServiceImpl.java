package edu.mum.mumsched.serviceImpl;

import edu.mum.mumsched.dao.CourseDAO;
import edu.mum.mumsched.domain.Course;
import edu.mum.mumsched.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDAO courseDAO;
    @Override
    public void save(Course course) {
        courseDAO.save(course);
    }

    @Override
    public Course getCourseByID(long id) {
        return courseDAO.findCourseById(id);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseDAO.findCourseByName(name);
    }

    @Override
    public void deleteCourseById(long id) {
         courseDAO.deleteById(id);
    }

    @Override
    public Iterable<Course> getAllCourses() {
        return courseDAO.findAll();
    }
}
