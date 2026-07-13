package io.foster.awesomeapp;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TimesheetService {
    @Autowired
    private TimesheetRepository timesheetRepository;

    public List<Timesheet> getAllRecords() {
        return (List<Timesheet>) timesheetRepository.findAll();
    }

    public Timesheet getRecordById(Integer id) {
        return timesheetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Запись с таким id не найден"));
    }

    public Timesheet saveRecord(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }
}
