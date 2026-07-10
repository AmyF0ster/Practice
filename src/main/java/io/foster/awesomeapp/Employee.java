package io.foster.awesomeapp;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Employee {
    @Id
    private Integer employeeId;
    private String name;
    private String position;
    private String department;
    private Date hiringDate;

    public Employee(Integer employeeId, String name, String position, String department, Date hiringDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.department = department;
        this.hiringDate = hiringDate;
    }
}
