package pl.com.coders.libria1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.coders.libria1.domain.Category;
import pl.com.coders.libria1.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Category>> getAllCat() {
        Iterable<Category> categories = categoryService.getAllCat();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public CategoryView getCat(@PathVariable Long id) {
        return categoryService.getCat(id);
    }

    @PostMapping
    public CategoryView createCat(@RequestBody CategoryCreateRequest categoryCreateRequest) {
        return categoryService.saveCat(categoryCreateRequest);
    }
}
