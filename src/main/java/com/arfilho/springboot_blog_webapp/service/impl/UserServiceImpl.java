package com.arfilho.springboot_blog_webapp.service.impl;

import com.arfilho.springboot_blog_webapp.dto.RegistrationDto;
import com.arfilho.springboot_blog_webapp.entity.Role;
import com.arfilho.springboot_blog_webapp.entity.User;
import com.arfilho.springboot_blog_webapp.repository.RoleRepository;
import com.arfilho.springboot_blog_webapp.repository.UserRepository;
import com.arfilho.springboot_blog_webapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getFirstName() + " " + registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        // use spring security to encrypt password
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("ROLE_GUEST");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
