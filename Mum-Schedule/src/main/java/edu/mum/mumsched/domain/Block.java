package edu.mum.mumsched.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Block {
    @Id
    @Column(name = "blockid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entryid", nullable = false)
    private Entry entry;
    @NotEmpty
    private String blockName;
    private String entryName;
    private int FPPNum;
    private int MPPNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "block")
    private List<Section> sections = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Schedule schedule;

    public Block() {
    }

    public Block(Entry entry, @NotEmpty String blockName, String entryName, int FPPNum, int MPPNum, LocalDate startDate, LocalDate endDate, List<Section> sections, Schedule schedule) {
        this.entry = entry;
        this.blockName = blockName;
        this.entryName = entryName;
        this.FPPNum = FPPNum;
        this.MPPNum = MPPNum;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sections = sections;
        this.schedule = schedule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
