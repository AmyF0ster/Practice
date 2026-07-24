package io.foster.awesomeapp;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class DayType {

    private Integer dayTypeId;
    @Column("DAY_TYPE")
    private String description;
    DayType() {
    }
    DayType(Integer dayTypeId, String dayType) {
        this.dayTypeId = dayTypeId;
        this.description = dayType;
    }

}
