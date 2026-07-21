package io.foster.awesomeapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController {

    private final TimesheetService timesheetService;

    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @GetMapping("/all")
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

    @GetMapping
    public ResponseEntity<List<Timesheet>> getTimesheetsByEmployeeIdAndDate(@RequestParam Integer employeeId, @RequestParam LocalDate startDate, LocalDate endDate) {
        List<Timesheet> timesheets = timesheetService.getTimesheetsByEmployeeIdAndDate(employeeId, startDate, endDate);
        return ResponseEntity.ok(timesheets);
    }
}
