package edu.classtrack.service;

import edu.classtrack.dto.Subject;
import edu.classtrack.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements CollegeService<Subject> {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

    public String delete(Subject subject) {
        Subject subject1 = subjectRepository.findById(subject.getId()).orElse(null);
        if (subject1 == null) {
            return "Subject not found";
        }
         subjectRepository.delete(subject);
        return "Subject deleted";
    }

}
