package edu.mum.mumsched.dao;


import edu.mum.mumsched.domain.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseDAO extends CrudRepository<Course,Long> {
    @Query("SELECT s from Course s where s.Id=:id" )
    public Course findCourseById(@Param("id")long id) ;
    @Query ("SELECT s from Course s where s.courseName=:courseName")
    public Course findCourseByName(@Param("courseName")String courseName);
    //@Query ("DELETE  from Course s where s.Id=:id")
    //public void deleteCourseById(@Param("id")long id);

}
