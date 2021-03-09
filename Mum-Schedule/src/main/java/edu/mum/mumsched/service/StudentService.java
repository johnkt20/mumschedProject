package edu.mum.mumsched.service;

import edu.mum.mumsched.domain.Student;

public interface StudentService {
    public void save(Student student);
    public Student getStudentById(long id);
    public Student getStudentByName(String name);
    public void deleteStudentById(long id);
    public Iterable<Student> getAllStudents();
}
