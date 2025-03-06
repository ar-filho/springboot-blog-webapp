package com.arfilho.springboot_blog_webapp.service;

import com.arfilho.springboot_blog_webapp.dto.RegistrationDto;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
}
