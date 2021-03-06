package edu.mum.mumsched.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    private String courseName;
    private String courseCode;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id=" + Id +
                ", courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
