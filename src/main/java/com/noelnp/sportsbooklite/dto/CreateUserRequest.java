package com.noelnp.sportsbooklite.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
       @NotBlank String firstName,
       @NotBlank String lastName,
       @Email String email,
       @Size(min = 8) String password
){}

