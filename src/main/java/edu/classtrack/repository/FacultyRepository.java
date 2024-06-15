package edu.classtrack.repository;

import edu.classtrack.dto.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long>{
}