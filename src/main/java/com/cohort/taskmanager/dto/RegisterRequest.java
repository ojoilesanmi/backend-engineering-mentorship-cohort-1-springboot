package com.cohort.taskmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "First name is required")
        @Size(max = 100,message = "First name cannot exceed 100 characters")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(max = 100,message = "First name cannot exceed 100 characters")
        String lastName,

        @NotBlank(message = "email is required")
        @Email(message = "Valid email must be provided")
        @Size(max = 150,message = "First name cannot exceed 100 characters")
        String email,

        @NotBlank(message = "email is required")
        @Size(min = 8, max = 72,  message = "Passwords must be between 8 and 72 characters")
        String password
) {
}
