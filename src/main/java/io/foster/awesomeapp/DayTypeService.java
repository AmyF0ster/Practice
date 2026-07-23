package io.foster.awesomeapp;

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

    public DayType saveDayType(DayType dayType) {
        return dayTypeRepository.save(dayType);
    }

    public DayType patchDayType(Integer id, DayTypePatchDTO dto) {
        DayType dayType = dayTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Тип дня"));
        if (!dto.getDescription().isEmpty()) {
            dayType.setDescription(dto.getDescription());
        }
        return dayTypeRepository.save(dayType);
    }

    public void deleteDayType(Integer id) {
        dayTypeRepository.deleteById(id);
    }
}
