package io.foster.awesomeapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet, Integer> {
    List<Timesheet> findByEmployeeIdAndDateBetween(Integer employeeId, LocalDate startDate, LocalDate endDate);
}
