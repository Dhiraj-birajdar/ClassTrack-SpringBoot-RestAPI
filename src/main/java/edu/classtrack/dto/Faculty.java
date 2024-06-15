package edu.classtrack.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;

@Entity
@Data
@NoArgsConstructor
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is required")
    private String name;

    @Email
    @Column(unique = true)
    @NotNull(message = "Email is required")
    private String email;

    @Column(name = "department_id")
    @NotNull(message = "Department ID is required")
    @Range(min = 1, message = "Department ID must be between 1 to 5", max = 5)
    private Long departmentId;
}

