package com.codemind.ems.dto;
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String empEmail;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public EmployeeDTO(Long id, String firstName, String lastName, String empEmail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empEmail = empEmail;
    }
}
