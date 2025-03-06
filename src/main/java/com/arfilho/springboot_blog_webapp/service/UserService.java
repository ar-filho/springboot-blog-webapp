package com.arfilho.springboot_blog_webapp.service;

import com.arfilho.springboot_blog_webapp.dto.RegistrationDto;
import com.arfilho.springboot_blog_webapp.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    User findByEmail(String email);
}
