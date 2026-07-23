package io.foster.awesomeapp;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TimesheetService {

    private final TimesheetRepository timesheetRepository;

    public TimesheetService(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    public List<Timesheet> getAllRecords() {
        return (List<Timesheet>) timesheetRepository.findAll();
    }

    public Timesheet getRecordById(Integer id) {
        return timesheetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Запись"));
    }

    public Timesheet saveRecord(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }

    public List<Timesheet> getTimesheetsByEmployeeIdAndDate(Integer employeeId, LocalDate startDate, LocalDate endDate) {
        return timesheetRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate);
    }

    public Timesheet patchTimesheet(Integer id, TimesheetPatchDTO dto) {
        Timesheet record = timesheetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Запись"));
        if (dto.getHours() != null) {
            if (dto.getHours() >= 0 || dto.getHours() <= 24) {
                record.setHours(dto.getHours());
            }
        }
        if (dto.getDayTypeId() != null) {
            record.setDayTypeId(dto.getDayTypeId());
        }
        return timesheetRepository.save(record);
    }
}
