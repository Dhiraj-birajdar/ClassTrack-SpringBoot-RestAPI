package edu.classtrack.service;

import edu.classtrack.dto.Faculty;
import edu.classtrack.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService implements CollegeService<Faculty> {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    public Optional<Faculty> findById(Long id) {
        return facultyRepository.findById(id);
    }

    public Faculty save(Faculty faculty) {
        try {
            facultyRepository.save(faculty);
            return faculty;
        } catch (Exception e) {
            return null;
        }
    }

    public Faculty update(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public String delete(Faculty faculty) {
        Faculty faculty1 = facultyRepository.findById(faculty.getId()).orElse(null);
        if (faculty1 == null) {
            return "Faculty not found";
        }
        facultyRepository.delete(faculty);
        return "Faculty deleted";
    }

}
