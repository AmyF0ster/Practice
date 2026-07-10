package io.foster.awesomeapp;

import lombok.Getter;

@Getter
public enum DayType {
    WORKDAY(1, "Работает"),
    VACATION(2, "В отпуске"),
    DAYOFF(3, "Отгул");
    private Integer dayTypeId;
    private String description;

    DayType(Integer dayTypeId, String description) {
        this.dayTypeId = dayTypeId;
        this.description = description;
    }

}
