package edu.mum.mumsched.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long Id;
    @NonNull
    private String username;
    @NonNull
    private String password;


//    @Enumerated(EnumType.STRING)
//    public Role role() {
//
//        return role;
//    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
