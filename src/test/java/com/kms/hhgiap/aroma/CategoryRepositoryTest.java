package com.kms.hhgiap.aroma;

import com.kms.hhgiap.aroma.category.Category;
import com.kms.hhgiap.aroma.category.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void testCreateCategory() {
        Category savedCategory = categoryRepository.save(new Category("Shirts"));
        assertThat(savedCategory.getId()).isGreaterThan(0);
    }
    @Test
    public void testImportCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Men"));
        categories.add(new Category("Women"));
        categories.add(new Category("Accessories"));
        categories.add(new Category("Footwear"));
        List<Category> saved = (List<Category>) categoryRepository.saveAll(categories);
        assertThat(saved.size()).isEqualTo(4);
    }
}
