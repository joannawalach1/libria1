package pl.com.coders.libria1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.coders.libria1.domain.Category;
import pl.com.coders.libria1.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> getAllCat() {
        Iterable<Category> categories = categoryService.getAllCat();
        return ResponseEntity.ok(categories);
    }
}
