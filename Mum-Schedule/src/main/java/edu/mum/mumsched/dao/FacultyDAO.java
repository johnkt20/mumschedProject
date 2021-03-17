package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Faculty;
import edu.mum.mumsched.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyDAO extends CrudRepository<Faculty,Long> {

    @Query("SELECT s from Faculty s where s.id=:id" )
    public Faculty findFacultyById(@Param("id")long id) ;
    @Query ("SELECT s from Faculty s where s.firstName=:firstName")
    public Faculty findFacultyByName(@Param("firstName")String firstName);
}
