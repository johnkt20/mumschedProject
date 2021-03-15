package edu.mum.mumsched.domain;


import edu.mum.mumsched.domain.EntryType;
import edu.mum.mumsched.domain.Student;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
    private String fppNumber;
    private String mppNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private EntryType entryType;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="entry")
    private List<Student> students = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "entry")
    private List<Block>blocks = new ArrayList<>();

    @OneToOne()
    private Schedule schedule;

    public Entry() {
    }

    public Entry(Long id, @NonNull String entryName, String fppNumber, String mppNumber, LocalDate startDate, LocalDate endDate, EntryType entryType, List<Student> students, List<Block> blocks, Schedule schedule) {
        this.id = id;
        this.entryName = entryName;
        this.fppNumber = fppNumber;
        this.mppNumber = mppNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.entryType = entryType;
        this.students = students;
        this.blocks = blocks;
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getFppNumber() {
        return fppNumber;
    }

    public void setFppNumber(String fppNumber) {
        this.fppNumber = fppNumber;
    }

    public String getMppNumber() {
        return mppNumber;
    }

    public void setMppNumber(String mppNumber) {
        this.mppNumber = mppNumber;
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

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", entryName='" + entryName + '\'' +
                ", fppNumber='" + fppNumber + '\'' +
                ", mppNumber='" + mppNumber + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", entryType=" + entryType +
                ", students=" + students +
                ", blocks=" + blocks +
                ", schedule=" + schedule +
                '}';
    }
}
