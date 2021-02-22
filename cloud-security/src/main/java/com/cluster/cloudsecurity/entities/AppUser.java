package com.cluster.cloudsecurity.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>();

    public AppUser(Long id, String name, String pw, Collection<AppRole> roles) {
        this.id = id;
        this.name = name;
        this.password = pw;
        this.roles = roles;
    }
    public AppUser(String name, String pw) {
        this.id = null;
        this.name = name;
        this.password = pw;
    }

    public AppUser() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }
}
