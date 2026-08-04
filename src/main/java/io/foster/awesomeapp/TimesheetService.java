package io.foster.awesomeapp;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TimesheetService {

    private final TimesheetRepository timesheetRepository;
    private final EmployeeRepository employeeRepository;
    private final DayTypeRepository dayTypeRepository;

    public TimesheetService(TimesheetRepository timesheetRepository, EmployeeRepository employeeRepository, DayTypeRepository dayTypeRepository) {
        this.timesheetRepository = timesheetRepository;
        this.employeeRepository = employeeRepository;
        this.dayTypeRepository = dayTypeRepository;
    }

    public List<Timesheet> getAllRecords() {
        return (List<Timesheet>) timesheetRepository.findAll();
    }

    public Timesheet getRecordById(Integer id) {
        return timesheetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Запись"));
    }

    public Timesheet createRecord(TimesheetDTO dto) {
        Timesheet newTimesheet = new Timesheet();
        newTimesheet.setDate(dto.getDate());
        if (employeeRepository.existsById(dto.getEmployeeId())) {
            newTimesheet.setEmployeeId(dto.getEmployeeId());
        } else {
            throw new NotFoundException(dto.getEmployeeId(), "Сотрудник");
        }
        newTimesheet.setHours(dto.getHours());
        if (dayTypeRepository.existsById(dto.getDayTypeId())) {
            newTimesheet.setDayTypeId(dto.getDayTypeId());
        } else {
            throw new NotFoundException(dto.getDayTypeId(), "Тип дня");
        }
        return timesheetRepository.save(newTimesheet);
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
