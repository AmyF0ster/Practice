package io.foster.awesomeapp;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class SystemSettingDTO {

    private String name;
    private Integer value;
    private String description;
}
