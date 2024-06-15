package edu.classtrack.service;

import edu.classtrack.dto.Department;
import edu.classtrack.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements CollegeService<Department> {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Department update(Department department) {
        return departmentRepository.save(department);
    }

    public String delete(Department department) {
        Department existingDepartment = departmentRepository.findById(department.getId()).orElse(null);
        if(existingDepartment == null)
            return "Department not found!";
         departmentRepository.delete(department);
        return "Department deleted successfully!";
    }

}
