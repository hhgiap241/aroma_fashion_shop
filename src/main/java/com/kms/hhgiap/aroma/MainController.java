package com.kms.hhgiap.aroma;

import com.kms.hhgiap.aroma.product.Product;
import com.kms.hhgiap.aroma.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String showHomePage(Model model) {
        model.addAttribute("pageTitle", "Home");
        return "index";
    }

//    @GetMapping("/single-product")
//    public String showProductDetailPage(Model model) {
//        model.addAttribute("pageTitle", "Single Product");
//        return "single-product";
//    }
    @GetMapping("/checkout")
    public String showCheckoutPage(Model model) {
        model.addAttribute("pageTitle", "Checkout");
        return "checkout";
    }
    @GetMapping("/single-order")
    public String showOrderDetailPage(Model model) {
        model.addAttribute("pageTitle", "Order Detail");
        return "single-order";
    }
    @GetMapping("/cart")
    public String showCartPage(Model model) {
        model.addAttribute("pageTitle", "Cart");
        return "cart";
    }
    @GetMapping("/blogs")
    public String showBlogListPage(Model model) {
        model.addAttribute("pageTitle", "Blogs");
        return "blog";
    }
    @GetMapping("/single-blog")
    public String showBlogDetailPage(Model model) {
        model.addAttribute("pageTitle", "Single Blog");
        return "single-blog";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Login");
        return "login";
    }
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Register");
        return "register";
    }
    @GetMapping("/contact")
    public String showContactPage(Model model) {
        model.addAttribute("pageTitle", "Contact");
        return "contact";
    }
}
