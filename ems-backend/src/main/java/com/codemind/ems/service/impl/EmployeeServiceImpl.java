package com.codemind.ems.service.impl;

import com.codemind.ems.dto.EmployeeDTO;
import com.codemind.ems.entity.Employee;
import com.codemind.ems.exception.ResourceNotFoundException;
import com.codemind.ems.mapper.EmployeeMapper;
import com.codemind.ems.repository.EmployeeRepository;
import com.codemind.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee= EmployeeMapper.maoToEmployee(employeeDTO);
        Employee savedEmployee1=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee1);
    }

    @Override
    public EmployeeDTO getEmpById(Long empId) {
        Employee employee=employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee With Given id is found : " + empId));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()-> new RuntimeException("Employee is not present with given Id"+employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmpEmail(updatedEmployee.getEmpEmail());
        Employee updatedEmployeeObj=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public void deleteEmployee(Long empId) {
        Employee employee=employeeRepository.findById(empId).orElseThrow(()-> new RuntimeException("Employee is not present with given Id: "+empId));
         employeeRepository.deleteById(empId);
    }

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
