package io.foster.awesomeapp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemSettingsService {
    private final SystemSettingsRepository systemSettingsRepository;

    public SystemSettingsService(SystemSettingsRepository systemSettingsRepository) {
        this.systemSettingsRepository = systemSettingsRepository;
    }

    public List<SystemSettings> getAllSettings() {
        return (List<SystemSettings>) systemSettingsRepository.findAll();
    }

    public Integer getNormalDayHours() {
        SystemSettings systemSettings = systemSettingsRepository.findById("normal_day_hours")
                .orElseThrow(() -> new SettingNotFound("Норма часов в рабочем дне"));
        return systemSettings.getValue();
    }

    public Integer getNormalWeekHours() {
        SystemSettings systemSettings = systemSettingsRepository.findById("normal_week_hours")
                .orElseThrow(() -> new SettingNotFound("Норма часов в рабочей неделе"));
        return systemSettings.getValue();
    }

    public SystemSettings createSetting(SystemSettingDTO dto) {
        SystemSettings newSetting = new SystemSettings();
        if (!systemSettingsRepository.existsById(dto.getName())) {
            newSetting.setName(dto.getName());
        }
        newSetting.setValue(dto.getValue());
        newSetting.setDescription(dto.getDescription());
        return systemSettingsRepository.save(newSetting);
    }

    public SystemSettings patchSystemSettings(String name, SystemSettingsPatchDTO dto) {
        SystemSettings setting = systemSettingsRepository.findById(name)
                .orElseThrow(() -> new SettingNotFound(""));
        if (dto.getValue() != null) {
            setting.setValue(dto.getValue());
        }
        if (!dto.getDescription().isEmpty()) {
            setting.setDescription(dto.getDescription());
        }
        return systemSettingsRepository.save(setting);
    }

    public void deleteSetting(String name) {
        if (!systemSettingsRepository.existsById(name)) {
            throw new SettingNotFound("Настройка с именем '" + name + "' не найдена");
        }
        systemSettingsRepository.deleteById(name);
    }
}
