package edu.classtrack.service;

import edu.classtrack.dto.Course;
import edu.classtrack.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CollegeService<Course> {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public Course update(Course course) {
        return courseRepository.save(course);
    }

    public String delete(Course course) {
        Course existingCourse = courseRepository.findById(course.getId()).orElse(null);
        if(existingCourse == null)
            return "Course not found!";
         courseRepository.delete(course);
        return "Course deleted successfully!";
    }

}
