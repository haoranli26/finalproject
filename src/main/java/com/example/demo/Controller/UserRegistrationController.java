package com.example.demo.Controller;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/registration")
    public class UserRegistrationController {

        @Autowired
        private UserService userService;

        @ModelAttribute("user")
        public UserRegistrationDto userRegistrationDto() {
            return new UserRegistrationDto();
        }

        @GetMapping
        public String showRegistrationForm(Model model) {
            return "registration";
        }

        @PostMapping
        public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result){

            User existing = userService.findUserByEmail(userDto.getEmail());
            if (existing != null){
                result.rejectValue("email", null, "There is already an account registered with that email");
            }

            if (result.hasErrors()){
                return "registration";
            }

            userService.save(userDto);
            return "redirect:/registration?success";
        }
    }


