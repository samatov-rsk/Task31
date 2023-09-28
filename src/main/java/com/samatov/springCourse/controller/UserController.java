package com.samatov.springCourse.controller;

import com.samatov.springCourse.model.User;
import com.samatov.springCourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Integer userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        return "show";
    }

    @GetMapping("/new")
    public String getNewUserPage(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Integer userId) {
        model.addAttribute("user", userService.getUserById(userId ));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Integer userId) {
        userService.updateUser(userId, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer userId) {
        userService.removeUser(userId);
        return "redirect:/users";
    }
}

