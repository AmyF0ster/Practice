package io.foster.awesomeapp.dto;

import lombok.Data;

@Data
public class TimesheetPatchDTO {

    private Float hours;
    private Integer dayTypeId;
}
