package edu.mum.mumsched.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    private String courseName;
    private String courseCode;
    private int credit;
    @Digits(integer=10, fraction=0, message = "{invalidNumber.message}")
    private int maxStudent;

    @ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    //@OneToMany(fetch = FetchType.LAZY)
    private List<Course> prerequisites = new ArrayList<>();
    @OneToMany(mappedBy="course")
    private List<Section> sections;

    @Digits(integer=10, fraction=0, message = "{invalidNumber.message}")
    private int level;

    public Course() {
    }

    public Course(String courseName, String courseCode, int credit, @Digits(integer = 10, fraction = 0, message = "{invalidNumber.message}") int maxStudent, List<Course> prerequisites, List<Section> sections, @Digits(integer = 10, fraction = 0, message = "{invalidNumber.message}") int level) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credit = credit;
        this.maxStudent = maxStudent;
        this.prerequisites = prerequisites;
        this.sections = sections;
        this.level = level;
    }

    public Boolean hasPreRequisite() {
        return this.prerequisites != null;
    }



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

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
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
