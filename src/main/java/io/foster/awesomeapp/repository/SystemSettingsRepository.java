package io.foster.awesomeapp.repository;

import io.foster.awesomeapp.entity.SystemSettings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemSettingsRepository extends CrudRepository<SystemSettings, String> {

}
