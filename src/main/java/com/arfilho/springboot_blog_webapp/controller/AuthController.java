package com.arfilho.springboot_blog_webapp.controller;

import com.arfilho.springboot_blog_webapp.dto.RegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // handler method to handle user registration request
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        // this object holds form data
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }
}