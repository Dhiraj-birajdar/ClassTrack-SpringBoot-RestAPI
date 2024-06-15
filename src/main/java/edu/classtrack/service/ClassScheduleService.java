package edu.classtrack.service;

import edu.classtrack.dto.ClassSchedule;
import edu.classtrack.repository.ClassScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassScheduleService implements CollegeService<ClassSchedule> {

    private final ClassScheduleRepository classScheduleRepository;

    public ClassScheduleService(ClassScheduleRepository classScheduleRepository) {
        this.classScheduleRepository = classScheduleRepository;
    }

    public List<ClassSchedule> findAll() {
        return classScheduleRepository.findAll();
    }

    public Optional<ClassSchedule> findById(Long id) {
        return classScheduleRepository.findById(id);
    }

    public ClassSchedule save(ClassSchedule classSchedule) {
        return classScheduleRepository.save(classSchedule);
    }

    public ClassSchedule update(ClassSchedule classSchedule) {
        return classScheduleRepository.save(classSchedule);
    }

    public String delete(ClassSchedule classSchedule) {
        ClassSchedule existingClassSchedule = classScheduleRepository.findById(classSchedule.getId()).orElse(null);
        if(existingClassSchedule == null)
            return "ClassSchedule not found!";
        classScheduleRepository.delete(classSchedule);
        return "ClassSchedule deleted successfully!";
    }
}
