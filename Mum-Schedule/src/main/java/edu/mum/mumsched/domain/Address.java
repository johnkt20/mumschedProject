package edu.mum.mumsched.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Data
@Entity
//@Getter
//@Setter
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    private String telephone;
    private String city;
    private String state;
    private long zipcode;
    private String country;

    @OneToOne(mappedBy = "address")
    private Admin admin;
    @OneToOne(mappedBy = "address")
    private Student student;

    public Address() {
    }

    public Address(String telephone, String city, String state, long zipcode, String country, Admin admin, Student student) {
        this.telephone = telephone;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
        this.admin = admin;
        this.student = student;
    }

    public Long getId() {
        return Id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
