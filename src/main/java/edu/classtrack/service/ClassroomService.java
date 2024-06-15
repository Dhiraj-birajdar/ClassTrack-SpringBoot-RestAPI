package edu.classtrack.service;

import edu.classtrack.dto.Classroom;
import edu.classtrack.repository.ClassroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService implements CollegeService<Classroom> {

    private final ClassroomRepository classroomRepository;

    ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    public Optional<Classroom> findById(Long id) {
        return classroomRepository.findById(id);
    }

    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom update(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public String delete(Classroom classroom) {
        Classroom existingClassroom = classroomRepository.findById(classroom.getId()).orElse(null);
        if(existingClassroom == null)
            return "Classroom not found!";
         classroomRepository.delete(classroom);
        return "Classroom deleted successfully!";
    }

}
