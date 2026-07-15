package io.foster.awesomeapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet, Integer> {
}
