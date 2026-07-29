package io.foster.awesomeapp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemSettingsService {
    private final SystemSettingsRepository systemSettingsRepository;
    public static final String NORMAL_DAY_HOURS = "normal_day_hours";
    public static final String NORMAL_WEEK_HOURS = "normal_week_hours";

    public SystemSettingsService(SystemSettingsRepository systemSettingsRepository) {
        this.systemSettingsRepository = systemSettingsRepository;
    }

    public List<SystemSettings> getAllSettings() {
        return (List<SystemSettings>) systemSettingsRepository.findAll();
    }

    public Integer getNormalDayHours() {
        SystemSettings systemSettings = systemSettingsRepository.findById("NORMAL_DAY_HOURS")
                .orElseThrow(() -> new SettingNotFound("Норма часов в рабочем дне"));
        return Integer.parseInt(systemSettings.getValue());
    }

    public Integer getNormalWeekHours() {
        SystemSettings systemSettings = systemSettingsRepository.findById("NORMAL_WEEK_HOURS")
                .orElseThrow(() -> new SettingNotFound("Норма часов в рабочей неделе"));
        return Integer.parseInt(systemSettings.getValue());
    }

    public SystemSettings patchSystemSettings(String name, SystemSettingsPatchDTO dto) {
        SystemSettings setting = systemSettingsRepository.findById(name)
                .orElseThrow(() -> new SettingNotFound(""));
        if (!dto.getValue().isEmpty()) {
            setting.setValue(dto.getValue());
        }
        if (!dto.getDescription().isEmpty()) {
            setting.setDescription(dto.getDescription());
        }
        return systemSettingsRepository.save(setting);
    }

}
