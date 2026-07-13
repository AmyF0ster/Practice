package io.foster.awesomeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController {
    @Autowired
    private TimesheetService timesheetService;

    @GetMapping("/timesheets")
    public List<Timesheet> getRecord() {
        return timesheetService.getAllRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Timesheet> getRecordById(@PathVariable Integer id) {
        Timesheet timesheet = timesheetService.getRecordById(id);
        return ResponseEntity.ok(timesheet);
    }

    @PostMapping
    public ResponseEntity<Timesheet> createRecord(@RequestBody Timesheet timesheet) {
        Timesheet newRecord = timesheetService.saveRecord(timesheet);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRecord);
    }
}
