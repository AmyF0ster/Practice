package io.foster.awesomeapp.service;

import io.foster.awesomeapp.dto.EmployeeDTO;
import io.foster.awesomeapp.mapper.EmployeeMapper;
import io.foster.awesomeapp.repository.EmployeeRepository;
import io.foster.awesomeapp.exception.NotFoundException;
import io.foster.awesomeapp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Сотрудник"));
    }

    public Employee createEmployee(EmployeeDTO dto) {
        Employee newEmployee = employeeMapper.mapToEmployee(dto);
        return employeeRepository.save(newEmployee);
    }

    public Employee updateEmployee(Integer id, EmployeeDTO dto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Сотрудник"));
        Employee updatedEmployee = employeeMapper.mapToEmployee(dto);
        updatedEmployee.setEmployeeId(id);
        return employeeRepository.save(updatedEmployee);
    }
}
