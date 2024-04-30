package peaksoft.api;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.User;
import peaksoft.service.UserService;

@Controller
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserApi {

    private final UserService userService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "getAllUsers";
    }

    @GetMapping("/new")
    public String createUser(Model model) {
        model.addAttribute("newUser", new User());
        return "newUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/userId")
    public String getUser(@PathVariable Long userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        return "updateUser";
    }

    @PostMapping("/{userId}/update")
    public String updateUser(@PathVariable Long userId ,
                             @ModelAttribute("user")User user){
        userService.update(userId,user);
        return "redirect:/api/users";
    }

    @GetMapping("/{userId}/delete")
    public String deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return "redirect:/users";
    }














}
