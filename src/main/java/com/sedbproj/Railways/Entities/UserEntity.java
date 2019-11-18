package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User", schema = "RailwaysV3", catalog = "")
public class UserEntity {
    private int userId;
    private String fname;
    private String lname;
    private String email;
    private String password;

    @Basic
    @Column(name = "SSN")
    private Long ssn;

    private EmployeeEntity employee;
    private PassengerEntity passenger;

    public UserEntity() {

    }

    public UserEntity(String fname, String lname, String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }

    public UserEntity(UserEntity user) {
        if (user.getUserId() != 0) {
            this.userId = user.getUserId();
        }
        if (!user.getFname().equals("")) {
            this.fname = user.getFname();
        }
        if (!user.getLname().equals("")) {
            this.lname = user.getLname();
        }
        if (!user.getEmail().equals("")) {
            this.email = user.getEmail();
        }
        if (!user.getPassword().equals("")) {
            this.password = user.getPassword();
        }
        this.ssn = user.getSsn();
        if (user.getEmployee() != null) {
            this.employee = user.getEmployee();
        }
        if (user.getPassenger() != null) {
            this.passenger = user.getPassenger();
        }
    }



    @Id
    @Column(name = "UserId", nullable = false)
    public int getUserId() {
        return userId;
    }
    //asdfasdfasasdfd I have conflict with increment
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

    public Long getSsn() {
        return ssn;
    }

    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    @OneToOne(targetEntity = EmployeeEntity.class, mappedBy = "usr", fetch=FetchType.LAZY)
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSN")
    public PassengerEntity getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerEntity passenger) {
        this.passenger = passenger;
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
