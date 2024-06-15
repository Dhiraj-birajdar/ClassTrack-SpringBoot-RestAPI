package edu.classtrack.security;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Role {

@Enumerated(EnumType.STRING)
    ADMIN,
    FACULTY,
    STUDENT
}
