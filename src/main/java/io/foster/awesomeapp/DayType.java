package io.foster.awesomeapp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DayType {
    private int dayTypeId;
    private String dayType;

    public DayType(int dayTypeId, String dayType){
        this.dayTypeId=dayTypeId;
        this.dayType=dayType;
    }
}
