package edu.mum.mumsched.service;

import edu.mum.mumsched.domain.Faculty;

import java.util.List;

public interface FacultyService {

    public void save(Faculty faculty);
    public Faculty getFacultyById(long id);
    public Faculty getFacultyByName(String name);
    public void deleteFacultyById(long id);
    public Iterable<Faculty> getAllFaculty();
}
