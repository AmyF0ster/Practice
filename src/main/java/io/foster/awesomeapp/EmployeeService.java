package io.foster.awesomeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }
    public Employee getEmployeeById(Integer id){
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.get();
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
