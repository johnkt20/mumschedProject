package edu.mum.mumsched.serviceImpl;

import edu.mum.mumsched.dao.CourseDAO;
import edu.mum.mumsched.dao.StudentDAO;
import edu.mum.mumsched.domain.Student;
import edu.mum.mumsched.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO studentDAO;
    @Override
    public void save(Student student) {
studentDAO.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        return studentDAO.findStudentById(id);
    }

    @Override
    public Student getStudentByName(String name) {
        return studentDAO.findStudentByName(name);
    }

    @Override
    public void deleteStudentById(long id) {
        studentDAO.deleteById(id);
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return studentDAO.findAll();
    }
}
