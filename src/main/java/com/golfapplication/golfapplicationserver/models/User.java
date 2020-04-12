package com.golfapplication.golfapplicationserver.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name="first_name")
    private String firstName;
    @NotBlank
    @Column(name="last_name")
    private String lastName;
    @NotBlank
    @Column(name="user_name")
    private String userName;
    @NotBlank
    @Column(name="password")
    private  String password;

   // @Transient
   // private String passwordCornfirm;

   // @ManyToMany
   // private Set<Role> roles;


    public User(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String userName, @NotBlank String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    private User(){

    }
    public  int getId() {
        return id;
    }

    public void setUser_id(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUseName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
