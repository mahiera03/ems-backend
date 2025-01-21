package com.codemind.ems.entity;

import jakarta.persistence.*;
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="emp_firstName")
    private String firstName;
    @Column(name="emp_lastName")
    private String lastName;
    @Column(name="emp_emailId", nullable = false, unique = true)
    private String empEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Employee(Long id, String firstName, String lastName, String empEmail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empEmail = empEmail;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                '}';
    }
}
