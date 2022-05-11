package com.kms.hhgiap.aroma.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public String showCategoryPage(Model model) {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("pageTitle", "Category");
        return "category";
    }
    @PostMapping("/api/import-category")
    public void importCategory(List<Category> categories) {
        categoryRepository.saveAll(categories);
    }

    @GetMapping("/api/get-category")
    @ResponseBody
    public List<Category> importCategory() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        return categories;
    }
}
