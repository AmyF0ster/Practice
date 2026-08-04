package io.foster.awesomeapp.controller;

import io.foster.awesomeapp.dto.SystemSettingsPatchDTO;
import io.foster.awesomeapp.entity.SystemSettings;
import io.foster.awesomeapp.service.SystemSettingsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/settings")
public class SystemSettingsController {
    private final SystemSettingsService systemSettingsService;

    public SystemSettingsController(SystemSettingsService systemSettingsService) {
        this.systemSettingsService = systemSettingsService;
    }

    @GetMapping
    public ResponseEntity<List<SystemSettings>> getAllSettings() {
        return ResponseEntity.ok(systemSettingsService.getAllSettings());
    }

    @PatchMapping("/{name}")
    public ResponseEntity<SystemSettings> patchSetting(@PathVariable String name, @RequestBody SystemSettingsPatchDTO dto) {
        return ResponseEntity.ok(systemSettingsService.patchSystemSettings(name, dto));
    }

}
