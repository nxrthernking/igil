package com.example.igil.controller;

import com.example.igil.model.User;
import com.example.igil.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/registration")
public class RegistrationController {

    private final UserService userService;

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String registration(@ModelAttribute User user){
        userService.add(user);
        return "redirect:/home";
    }
}
