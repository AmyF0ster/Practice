package io.foster.awesomeapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daytypes")
public class DayTypeController {

    public final DayTypeService dayTypeService;

    public DayTypeController(DayTypeService dayTypeService) {
        this.dayTypeService = dayTypeService;
    }

    @GetMapping
    public List<DayType> getAllDayTypes() {
        return dayTypeService.getAllDayTypes();
    }

    @PostMapping
    public ResponseEntity<DayType> createDayType(@RequestBody DayTypePatchDTO dto) {
        DayType newDayType = dayTypeService.createDayType(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDayType);
    }

    @PatchMapping("/id")
    public ResponseEntity<DayType> patchDayType(@PathVariable Integer id, @RequestBody DayTypePatchDTO dto) {
        return ResponseEntity.ok(dayTypeService.patchDayType(id, dto));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteDayType(@PathVariable Integer id) {
        dayTypeService.deleteDayType(id);
        return ResponseEntity.noContent().build();
    }
}
