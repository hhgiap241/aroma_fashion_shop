package com.kms.hhgiap.aroma.product;

import com.kms.hhgiap.aroma.category.Category;
import com.kms.hhgiap.aroma.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.Path;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/single-product/{id}")
    public String showProductDetailPage(Model model, @PathVariable("id") Integer id) {
        Product product = productRepository.findById(id).get();
        model.addAttribute("product", product);
        model.addAttribute("pageTitle", "Single Product");
        return "single-product";
    }
    @GetMapping("/add-product")
    public String showAddProductPage(Model model) {
        List<Category> categoryList = (List<Category>) categoryRepository.findAll();
        System.out.println(categoryList.size());
        model.addAttribute("product", new Product());
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("pageTitle", "Add New Product");
        return "add-product";
    }
    @PostMapping("/add-product")
    public String addProduct(Product product) {
        productRepository.save(product);
        return "redirect:/category";
    }
}
