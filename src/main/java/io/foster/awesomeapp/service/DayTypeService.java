package io.foster.awesomeapp.service;

import io.foster.awesomeapp.dto.DayTypePatchDTO;
import io.foster.awesomeapp.repository.DayTypeRepository;
import io.foster.awesomeapp.exception.NotFoundException;
import io.foster.awesomeapp.entity.DayType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayTypeService {
    private final DayTypeRepository dayTypeRepository;

    public DayTypeService(DayTypeRepository dayTypeRepository) {
        this.dayTypeRepository = dayTypeRepository;
    }

    public List<DayType> getAllDayTypes() {
        return (List<DayType>) dayTypeRepository.findAll();
    }

    public DayType createDayType(DayTypePatchDTO dto) {
        DayType dayType = new DayType();
        dayType.setDescription(dto.getDescription());
        return dayTypeRepository.save(dayType);
    }

    public DayType patchDayType(Integer id, DayTypePatchDTO dto) {
        DayType dayType = dayTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Тип дня"));
        if (dto.getDescription() != null && !dto.getDescription().isEmpty()) {
            dayType.setDescription(dto.getDescription());
        }
        return dayTypeRepository.save(dayType);
    }

    public void deleteDayType(Integer id) {
        dayTypeRepository.deleteById(id);
    }
}
