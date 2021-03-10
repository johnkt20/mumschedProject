package edu.mum.mumsched.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

//@Data
@Entity
//@Getter
//@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @OneToOne
    private Address address;
    @OneToOne
    private Account account;

    private String email;
    private String password;

    private int active;

    public Admin() {
    }

    public Admin( Address address, Account account, String email, String password, int active) {
        this.address = address;
        this.account = account;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public Long getId() {
        return id;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
