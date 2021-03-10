package edu.mum.mumsched.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private String studentId;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="entryID", nullable = true)
    private Entry entry;
    @OneToMany
    private List<Grade> grades = new ArrayList<>();
    private  StudentType studentType;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @ManyToMany(
            fetch=FetchType.LAZY
    )
    @JoinTable(
            name="section_students",
            joinColumns={@JoinColumn(name="student_id")},
            inverseJoinColumns={@JoinColumn(name="section_id")}
    )
    private List<Section> sections = new ArrayList<>();

    public void addSection(Section section){
        this.sections.add(section);
    }

    public Student() {
    }

    public Student(String firstName, String lastName, String email, String studentId, Entry entry, List<Grade> grades, StudentType studentType, Address address, List<Section> sections) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentId = studentId;
        this.entry = entry;
        this.grades = grades;
        this.studentType = studentType;
        this.address = address;
        this.sections = sections;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }


}
