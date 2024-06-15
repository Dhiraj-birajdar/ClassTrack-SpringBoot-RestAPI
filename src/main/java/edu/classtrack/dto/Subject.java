package edu.classtrack.dto;

import io.swagger.v3.oas.models.annotations.OpenAPI31;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name is required")
	private String name;

	@Column(name = "course_id")
	@NotNull(message = "Course ID is required")
	private Long courseId;
}

