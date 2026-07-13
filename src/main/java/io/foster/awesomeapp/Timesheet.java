package io.foster.awesomeapp;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
public class Timesheet {
    @Id
    private Integer recordId;
    private Date date;
    @Column("employee_FK")
    private Integer employeeId;
    private Float hours;
    @Column("day_type_FK")
    private Integer dayTypeId;

    public Timesheet(Integer recordId, Date date, Integer employeeFK, Float hours, Integer dayTypeFK) {
        this.recordId = recordId;
        this.date = date;
        this.employeeId = employeeFK;
        this.hours = hours;
        this.dayTypeId = dayTypeFK;
    }
}
