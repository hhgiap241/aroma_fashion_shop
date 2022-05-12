package com.kms.hhgiap.aroma.category;

import com.kms.hhgiap.aroma.brand.Brand;
import com.kms.hhgiap.aroma.brand.BrandRepository;
import com.kms.hhgiap.aroma.product.Product;
import com.kms.hhgiap.aroma.product.ProductRepository;
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
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping("/category")
    public String showCategoryPage(Model model) {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        List<Product> products = (List<Product>) productRepository.findAll();
        List<Brand> brands = (List<Brand>) brandRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("productList", products);
        model.addAttribute("brandList", brands);
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
