package io.foster.awesomeapp;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Timesheet {
    private int recordId;
    private Date date;
    private int employeeFK;
    private Float hours;
    private int dayTypeFK;

    public Timesheet(int recordId, Date date, int employeeFK, Float hours, int dayTypeFK){
        this.recordId=recordId;
        this.date=date;
        this.employeeFK=employeeFK;
        this.hours=hours;
        this.dayTypeFK=dayTypeFK;
    }
}
