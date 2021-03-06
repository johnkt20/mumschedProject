package edu.mum.mumsched.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Entry entry;
    @OneToMany
    private List<RegisterRecorde> registerRecordes=new ArrayList<>();



}
