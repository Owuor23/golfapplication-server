package com.golfapplication.golfapplicationserver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.javafx.beans.IDProperty;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="users")
@JsonIgnoreProperties("{\"hibernateLazyInitializer\",\"handler\"}")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long user_id;

    private String first_name;
    private String last_name;
    private String username;
    private  String password;

    @Transient
    private String passwordCornfirm;

    @ManyToMany
    private Set<Role> roles;

    public User(){

    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getPasswordCornfirm() {
        return passwordCornfirm;
    }

    public void setPasswordCornfirm(String passwordCornfirm) {
        this.passwordCornfirm = passwordCornfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
