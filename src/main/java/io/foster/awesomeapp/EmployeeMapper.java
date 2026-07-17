package io.foster.awesomeapp;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee employeeMap(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setPosition(dto.getPosition());
        employee.setDepartment(dto.getDepartment());
        employee.setHiringDate(dto.getHiringDate());
        return employee;
    }
}
