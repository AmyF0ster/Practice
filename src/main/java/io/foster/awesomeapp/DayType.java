package io.foster.awesomeapp;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public enum DayType {
    WORKDAY(1, "Работает"),
    VACATION(2, "В отпуске"),
    DAYOFF(3, "Отгул"),
    SICKDAY(4, "Больничный");

    private Integer dayTypeId;
    private String description;

    DayType(Integer dayTypeId, String description) {
        this.dayTypeId = dayTypeId;
        this.description = description;
    }

}
