package edu.classtrack.repository;

import edu.classtrack.dto.FacultyAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyAttendanceRepository extends JpaRepository<FacultyAttendance, Long>{
}

