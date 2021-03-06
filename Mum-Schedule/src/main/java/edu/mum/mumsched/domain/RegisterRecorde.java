package edu.mum.mumsched.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class RegisterRecorde {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String period;
    private String courseCode;
    private String title;
    private String faculty;
    private LocalDate start;

}
