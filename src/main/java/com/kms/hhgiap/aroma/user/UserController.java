package com.kms.hhgiap.aroma.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {
    @Autowired private UserService userService;

    @PostMapping("/register/save")
    public String createUser(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.createUser(user);
            redirectAttributes.addFlashAttribute("message", "Add user successfully!");
            return "redirect:/login";
        } catch (UserException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/register?"+e.getMessage().toLowerCase().replace(" ", "_");
        }
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        System.out.println(user.toString());
//        model.addAttribute("user", user);
        try {
            if (userService.login(user.getEmail(), user.getPassword())) {
                redirectAttributes.addFlashAttribute("username", user.getEmail().split("@")[0]);
                return "redirect:/"; // redirect to home page
            }
        } catch (UserException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/login?"+e.getMessage().toLowerCase().replace(" ", "_");
        }
        return null;
    }
}
