package com.cluster.cloudsecurity.entities;

import javax.persistence.*;
import java.util.Collection;
@Entity
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private Collection<AppUser> appUsers;

    public AppRole(Long id, String name, Collection<AppUser> appUsers) {
        this.id = id;
        this.name = name;
        this.appUsers = appUsers;
    }

    public AppRole() {
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

    public Collection<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(Collection<AppUser> appUsers) {
        this.appUsers = appUsers;
    }
}
