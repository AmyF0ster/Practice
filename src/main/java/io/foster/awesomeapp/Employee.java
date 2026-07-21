package io.foster.awesomeapp;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

@Data
public class Employee {
    @Id
    @Column("EMPLOYEE_ID")
    private Integer employeeId;
    @Column("NAME")
    private String name;
    @Column("POSITION")
    private String position;
    @Column("DEPARTMENT")
    private String department;
    @Column("HIRING_DATE")
    private LocalDate hiringDate;

    public Employee() {
    }

    public Employee(Integer employeeId, String name, String position, String department, LocalDate hiringDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.department = department;
        this.hiringDate = hiringDate;
    }
}
