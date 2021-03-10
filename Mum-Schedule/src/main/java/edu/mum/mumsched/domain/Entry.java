package edu.mum.mumsched.domain;



import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Entry {
    @Id
    @Column(name = "entryid")
    //@GeneratedValue(strategy= GenerationType.AUTO ,generator = "native")
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    @NonNull
    private String  entryName;
    private int FPPNum;
    private int MPPNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate StartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate EndDate;
    private EntryType entryType;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="entry")
    private List<Student> students = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "entry")
    private List<Block>blocks = new ArrayList<>();

    @OneToOne()
    private Schedule schedule;

    public Entry() {
    }

    public Entry(Long id,  String entryName, int FPPNum, int MPPNum, LocalDate startDate, LocalDate endDate, EntryType entryType, List<Student> students, List<Block> blocks, Schedule schedule) {
        this.id = id;
        this.entryName = entryName;
        this.FPPNum = FPPNum;
        this.MPPNum = MPPNum;
        StartDate = startDate;
        EndDate = endDate;
        this.entryType = entryType;
        this.students = students;
        this.blocks = blocks;
        this.schedule = schedule;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public int getFPPNum() {
        return FPPNum;
    }

    public void setFPPNum(int FPPNum) {
        this.FPPNum = FPPNum;
    }

    public int getMPPNum() {
        return MPPNum;
    }

    public void setMPPNum(int MPPNum) {
        this.MPPNum = MPPNum;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
