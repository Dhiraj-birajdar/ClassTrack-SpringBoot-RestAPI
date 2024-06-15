package edu.classtrack.repository;

import edu.classtrack.dto.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, Long> {
}

