package com.codemind.ems.mapper;

import com.codemind.ems.dto.EmployeeDTO;
import com.codemind.ems.entity.Employee;



public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmpEmail()
        );
    }

    public static Employee maoToEmployee(EmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmpEmail()
        );
    }
}
