package edu.mum.mumsched.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Block blocks;
    @OneToMany
    private List<Course> courses=new ArrayList<>();


}
