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
    @GetMapping("/single-product")
    public String showProductDetailPage() {
        return "single-product";
    }
    @GetMapping("/checkout")
    public String showCheckoutPage() {
        return "checkout";
    }
    @GetMapping("/single-order")
    public String showOrderDetailPage() {
        return "single-order";
    }
    @GetMapping("/cart")
    public String showCartPage() {
        return "cart";
    }
    @GetMapping("/blogs")
    public String showBlogListPage() {
        return "blog";
    }
    @GetMapping("/single-blog")
    public String showBlogDetailPage() {
        return "single-blog";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }
    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";
    }
}
