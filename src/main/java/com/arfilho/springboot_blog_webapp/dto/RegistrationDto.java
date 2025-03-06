package com.arfilho.springboot_blog_webapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private Long id;

    @NotEmpty(message = "Name should not be empty!")
    private String firstName;

    @NotEmpty(message = "Name should not be empty!")
    private String lastName;

    @NotEmpty(message = "Email should not be empty or null!")
    @Email
    private String email;

    @NotEmpty(message = "Name should not be empty!")
    private String password;
}