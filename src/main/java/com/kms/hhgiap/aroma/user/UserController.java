package com.kms.hhgiap.aroma.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
