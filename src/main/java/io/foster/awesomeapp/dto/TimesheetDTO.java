package io.foster.awesomeapp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TimesheetDTO {
    private LocalDate date;
    private Integer employeeId;
    private Float hours;
    private Integer dayTypeId;
}
