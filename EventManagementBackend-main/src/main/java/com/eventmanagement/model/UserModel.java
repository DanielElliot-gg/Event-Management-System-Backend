package com.eventmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    private String username;
    private String uemail;
    private String upassword;
    private String role; // store "CLIENT", "STAFF", "PLANNER" or "ROLE_CLIENT"

    // getters and setters
    public Integer getUid() { return uid; }
    public void setUid(Integer uid) { this.uid = uid; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getUemail() { return uemail; }
    public void setUemail(String uemail) { this.uemail = uemail; }

    public String getUpassword() { return upassword; }
    public void setUpassword(String upassword) { this.upassword = upassword; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
