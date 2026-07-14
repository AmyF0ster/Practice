package io.foster.awesomeapp;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;


@Data
public class Timesheet {
    @Id
    @Column("RECORD_ID")
    private Integer recordId;
    @Column("DATE")
    private LocalDate date;
    @Column("EMPLOYEE_FK")
    private Integer employeeId;
    @Column("HOURS")
    private Float hours;
    @Column("DAY_TYPE_FK")
    private Integer dayTypeId;

    public Timesheet(Integer recordId, LocalDate date, Integer employeeFK, Float hours, Integer dayTypeFK) {
        this.recordId = recordId;
        this.date = date;
        this.employeeId = employeeFK;
        this.hours = hours;
        this.dayTypeId = dayTypeFK;
    }
}
