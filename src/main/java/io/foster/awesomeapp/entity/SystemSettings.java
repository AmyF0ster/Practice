package io.foster.awesomeapp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class SystemSettings {
    @Id
    @Column("NAME")
    private String name;
    @Column("SETTING_VALUE")
    private String value;
    @Column("DESCRIPTION")
    private String description;

    public SystemSettings() {
    }

    public SystemSettings(String name, String value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }
}
