package edu.classtrack.service;

import edu.classtrack.dto.FacultyAttendance;

import java.util.List;
import java.util.Optional;

public interface CollegeService<T> {

    public List<T> findAll();

    public Optional<T> findById(Long id);

    public T save(T t);

    public T update(T t);

    public String delete(T t);
}
