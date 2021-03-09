package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO extends CrudRepository<Student,Long> {
    @Query("SELECT s from Student s where s.Id=:id" )
    public Student findStudentById(@Param("id")long id) ;
    @Query ("SELECT s from Student s where s.firstName=:firstName")
    public Student findStudentByName(@Param("firstName")String firstName);
    //@Query ("DELETE  from Student s where s.Id=:id")
    //public void deleteCourseById(@Param("id")long id);
}
