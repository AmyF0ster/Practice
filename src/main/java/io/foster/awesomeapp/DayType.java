package io.foster.awesomeapp;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class DayType {
    //  WORKDAY(1, "Работает"),
    //  VACATION(2, "В отпуске"),
    // DAYOFF(3, "Отгул"),
    //SICKDAY(4, "Больничный");

    private Integer dayTypeId;
    @Column("DAY_TYPE")
    private String description;

    DayType(Integer dayTypeId, String dayType) {
        this.dayTypeId = dayTypeId;
        this.description = dayType;
    }

}
