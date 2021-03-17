package edu.mum.mumsched.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty
    // private ScheduleStatus status;
    private ScheduleStatus scheduleStatus;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "schedule")
    private List<Block> blockList = new ArrayList<>();

    @OneToOne(fetch=FetchType.LAZY,  cascade = CascadeType.REMOVE)//(mappedBy = "schedule")
    private Entry entry;

    public void addBlock(Block block){
        blockList.add(block);
    }

    public void addBlocks(List<Block> blocks){
        this.blockList.addAll(blocks);
    }

    public Schedule() {
    }

    public Schedule( ScheduleStatus scheduleStatus, List<Block> blockList, Entry entry) {
        this.scheduleStatus = scheduleStatus;
        this.blockList = blockList;
        this.entry = entry;
    }

    public ScheduleStatus getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(ScheduleStatus scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public List<Block> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<Block> blockList) {
        this.blockList = blockList;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public Long getId() {
        return id;
    }


}
