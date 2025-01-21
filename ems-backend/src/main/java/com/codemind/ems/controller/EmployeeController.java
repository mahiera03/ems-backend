package com.codemind.ems.controller;

import com.codemind.ems.dto.EmployeeDTO;
import com.codemind.ems.entity.Employee;
import com.codemind.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //Build Add Employee REST API
    @PostMapping("/employee/register")
    public ResponseEntity<EmployeeDTO> createEmployee( @RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee=employeeService.createEmployee(employeeDTO);
        return new  ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee REST API
    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> getEmpById(@PathVariable("id") Long empId){
        EmployeeDTO employeeDTO=employeeService.getEmpById(empId);
        return ResponseEntity.ok(employeeDTO);
    }

    //Build Get all Employees REST API
    @GetMapping("/employee/all")
    public ResponseEntity<List<EmployeeDTO>> getallEmployees(){
        List<EmployeeDTO> employees=employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build update Employee REST API
    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long empId, @RequestBody EmployeeDTO updatedEmployee){
        EmployeeDTO employeeDTO= employeeService.updateEmployee(empId, updatedEmployee);
        return ResponseEntity.ok(employeeDTO);
    }

    //Build Delete Employee REST API
    @DeleteMapping("/employee/{empId}")
    public  ResponseEntity<String> deleteEmployee(@PathVariable Long empId){
        employeeService.deleteEmployee(empId);
        return ResponseEntity.ok("Employee with Id: "+empId+" has been Deleted Successfully.");
    }
}
