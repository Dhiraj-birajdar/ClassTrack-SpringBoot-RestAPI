package edu.classtrack.repository;

import edu.classtrack.dto.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
