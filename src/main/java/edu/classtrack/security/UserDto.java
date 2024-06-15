package edu.classtrack.security;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Role is required")
    private String role;

}
