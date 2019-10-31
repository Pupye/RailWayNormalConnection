package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User", schema = "RailwaysV2", catalog = "")
public class UserEntity {
    private int userId;
    private String fname;
    private String lname;
    private String email;
    private String password;

    @Id
    @Column(name = "UserId", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Fname", nullable = true, length = 45)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Basic
    @Column(name = "Lname", nullable = true, length = 45)
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                Objects.equals(fname, that.fname) &&
                Objects.equals(lname, that.lname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, fname, lname, email, password);
    }
}
