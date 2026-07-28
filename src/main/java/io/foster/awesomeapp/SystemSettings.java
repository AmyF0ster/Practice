package io.foster.awesomeapp;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class SystemSettings {
    @Column("NAME")
    private String name;
    @Column("SETTING_VALUE")
    private Integer value;
    @Column("DESCRIPTION")
    private String description;
    public SystemSettings() {
    }
    public SystemSettings(String name, Integer value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }
}
