package io.foster.awesomeapp.mapper;

import io.foster.awesomeapp.dto.EmployeeDTO;
import io.foster.awesomeapp.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee mapToEmployee(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setPosition(dto.getPosition());
        employee.setDepartment(dto.getDepartment());
        employee.setHiringDate(dto.getHiringDate());
        return employee;
    }
}
