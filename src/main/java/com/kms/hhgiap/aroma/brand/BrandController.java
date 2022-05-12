package com.kms.hhgiap.aroma.brand;

import com.kms.hhgiap.aroma.category.Category;
import com.kms.hhgiap.aroma.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/add-brand")
    public String showAddBrandPage(Model model) {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("brand", new Brand());
        model.addAttribute("categoryList", categories);
        model.addAttribute("pageTitle", "Single Brand");
        return "add-brand";
    }
}
