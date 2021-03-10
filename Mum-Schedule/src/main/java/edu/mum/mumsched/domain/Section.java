package edu.mum.mumsched.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section {
    @Id
    @Column(name = "sectionid")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String sectionName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String classRoom;
    private Integer capacity;
    //    private Integer
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
    private List<Grade> grades = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name="course_id", nullable=true)
    private Course course;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blockID")
    private Block block;

    public Section() {
    }

    public Section(@NotEmpty String sectionName, LocalDate startDate, LocalDate endDate, String classRoom, Integer capacity, List<Grade> grades, Course course, Block block) {
        this.sectionName = sectionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.classRoom = classRoom;
        this.capacity = capacity;
        this.grades = grades;
        this.course = course;
        this.block = block;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
