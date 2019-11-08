package com.sedbproj.Railways.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Employee", schema = "RailwaysV3", catalog = "")
public class EmployeeEntity {
    @Id
    @Column(name = "UserId", nullable = false)
    private int userId;
    private String role;
    private Double salary;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private UserEntity usr;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Role", nullable = true, length = 45)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "Salary", nullable = true, precision = 0)
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return userId == that.userId &&
                Objects.equals(role, that.role) &&
                Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, role, salary);
    }
}
