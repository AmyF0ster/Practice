package io.foster.awesomeapp;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {
    private String name;
    private String position;
    private String department;
    private LocalDate hiringDate;
}
