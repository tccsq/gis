package com.pera.gis.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by csq on 2015/9/16.
 */
@Entity
@Table(name = "T_USER")
public class User extends CommonEntity<Integer> {
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String name;
    @Column(name = "password", nullable = false)
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
