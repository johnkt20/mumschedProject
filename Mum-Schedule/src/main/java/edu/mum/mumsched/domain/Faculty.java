package edu.mum.mumsched.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Value("${firstName:fer}")
    private String firstName;
    @Value("${firstName:fer}")
    private String LastName;
    @Value("${firstName:fer}")
    private String email;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @Value("${courseLoad:0}")
    private Integer courseLoad;
    private Integer intervalBetweenBlocks;
    @OneToOne
    private Address address;
    @OneToOne
    private Schedule schedule;
    @OneToOne
    private Account account;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Course> coursePreference = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Block> blockPreference = new ArrayList<>();


    public void deleteBlock(Long Id)
    {
        for (Block block:blockPreference
        ) {

            if( block.getId() == Id ) {

            }
        }
    }

    public Faculty() {
    }

    public Faculty(String firstName, String lastName, String email, String password, LocalDate startDate, Integer courseLoad, Integer intervalBetweenBlocks, Address address, Schedule schedule, Account account, List<Course> coursePreference, List<Block> blockPreference) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.password = password;
        this.startDate = startDate;
        this.courseLoad = courseLoad;
        this.intervalBetweenBlocks = intervalBetweenBlocks;
        this.address = address;
        this.schedule = schedule;
        this.account = account;
        this.coursePreference = coursePreference;
        this.blockPreference = blockPreference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getCourseLoad() {
        return courseLoad;
    }

    public void setCourseLoad(Integer courseLoad) {
        this.courseLoad = courseLoad;
    }

    public Integer getIntervalBetweenBlocks() {
        return intervalBetweenBlocks;
    }

    public void setIntervalBetweenBlocks(Integer intervalBetweenBlocks) {
        this.intervalBetweenBlocks = intervalBetweenBlocks;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Course> getCoursePreference() {
        return coursePreference;
    }

    public void setCoursePreference(List<Course> coursePreference) {
        this.coursePreference = coursePreference;
    }

    public List<Block> getBlockPreference() {
        return blockPreference;
    }

    public void setBlockPreference(List<Block> blockPreference) {
        this.blockPreference = blockPreference;
    }
}
