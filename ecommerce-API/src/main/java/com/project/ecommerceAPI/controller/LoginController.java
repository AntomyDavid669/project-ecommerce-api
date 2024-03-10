package com.project.ecommerceAPI.controller;

import com.project.ecommerceAPI.dto.UserDto;
import com.project.ecommerceAPI.entities.UserEntity;
import com.project.ecommerceAPI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {
    private UserService userService;

    //handle method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        //create model object to store form data
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model){
        UserEntity existingUser = userService.findByUsername(userDto.getUsername());

        if(existingUser != null && existingUser.getUsername() != null && !existingUser.getUsername().isEmpty()){
            result.rejectValue("username", null, "There is already an account registered");
        }
        if (result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/user")
    public String user(Model model){
        List<UserDto> userDto = userService.findAllUser();
        model.addAttribute("user", userDto);
        return "user";
    }

    @GetMapping("/login")
    public String login (){
        return "login";
    }
}
