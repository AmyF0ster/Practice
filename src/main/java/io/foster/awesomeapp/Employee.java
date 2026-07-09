package io.foster.awesomeapp;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Employee {
    private int employeeId;
    private String name;
    private String position;
    private String department;
    private Date hiringDate;

    public Employee (int employeeId, String name, String position, String department, Date hiringDate){
        this.employeeId=employeeId;
        this.name=name;
        this.position=position;
        this.department=department;
        this.hiringDate=hiringDate;
    }
}
