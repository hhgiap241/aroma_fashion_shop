package com.kms.hhgiap.aroma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String showHomePage() {
        return "index";
    }
    @GetMapping("/category")
    public String showCategoryPage() {
        return "category";
    }
}
