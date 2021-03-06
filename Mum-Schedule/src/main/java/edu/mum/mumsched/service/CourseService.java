package edu.mum.mumsched.service;


import edu.mum.mumsched.domain.Course;

public interface CourseService {

    public void save(Course course);
    public Course getCourseByID(long id);
    public Course getCourseByName(String name);
    public void deleteCourseById(long id);
    public Iterable<Course> getAllCourses();
}
