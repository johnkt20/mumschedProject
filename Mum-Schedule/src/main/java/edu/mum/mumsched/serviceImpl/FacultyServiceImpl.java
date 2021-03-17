package edu.mum.mumsched.serviceImpl;

import edu.mum.mumsched.dao.FacultyDAO;
import edu.mum.mumsched.domain.Faculty;
import edu.mum.mumsched.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyDAO facultyDAO;


    @Override
    public void save(Faculty faculty) {
        facultyDAO.save(faculty);
    }

    @Override
    public Faculty getFacultyById(long id) {
        return facultyDAO.findFacultyById(id);
    }

    @Override
    public Faculty getFacultyByName(String name) {
        return facultyDAO.findFacultyByName(name);
    }

    @Override
    public void deleteFacultyById(long id) {
    facultyDAO.deleteById(id);
    }

    @Override
    public Iterable<Faculty> getAllFaculty() {
        return facultyDAO.findAll();
    }
}
