package com.backend.User_service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private Integer id;
    private String username;
    private String password;
    private boolean active;
    private boolean authorised;

    // No-argument constructor
    public User() {
    }

    // All-argument constructor
    public User(Integer id, String username, String password, boolean active, boolean authorised) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.authorised = authorised;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isAuthorised() {
        return authorised;
    }

    public void setAuthorised(boolean authorised) {
        this.authorised = authorised;
    }

    // Optional: toString(), equals(), and hashCode()

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", authorised=" + authorised +
                '}';
    }
}
