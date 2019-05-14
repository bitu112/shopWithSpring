package com.gpch.login.controller;

import com.gpch.login.user.User;
import com.gpch.login.user.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userPanel(Principal principal, Model model){
        User user = userService.findByUsername(principal.getName());

        if (user!=null){
            model.addAttribute("user",user);
        }else
        {
            return "error/404";
        }
        return "user";
    }
}
