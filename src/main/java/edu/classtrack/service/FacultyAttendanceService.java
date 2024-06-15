package edu.classtrack.service;

import edu.classtrack.dto.FacultyAttendance;
import edu.classtrack.repository.FacultyAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyAttendanceService implements CollegeService<FacultyAttendance> {

    @Autowired
    private FacultyAttendanceRepository facultyAttendanceRepository;

    public List<FacultyAttendance> findAll() {
        return facultyAttendanceRepository.findAll();
    }

    public Optional<FacultyAttendance> findById(Long id) {
        return facultyAttendanceRepository.findById(id);
    }

    public FacultyAttendance save(FacultyAttendance facultyAttendance) {
        return facultyAttendanceRepository.save(facultyAttendance);
    }

    public FacultyAttendance update(FacultyAttendance facultyAttendance) {
        return facultyAttendanceRepository.save(facultyAttendance);
    }

    public String delete(FacultyAttendance fa) {
        FacultyAttendance existingFacultyAttendance = facultyAttendanceRepository.findById(fa.getId()).orElse(null);
        if(existingFacultyAttendance == null)
            return "FacultyAttendance not found!";
         facultyAttendanceRepository.delete(fa);
        return "FacultyAttendance deleted successfully!";
    }

}
