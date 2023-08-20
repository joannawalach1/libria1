package pl.com.coders.libria1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.coders.libria1.controller.BookCreateRequest;
import pl.com.coders.libria1.controller.BookView;
import pl.com.coders.libria1.controller.CategoryCreateRequest;
import pl.com.coders.libria1.controller.CategoryView;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.domain.Category;
import pl.com.coders.libria1.mapper.CategoryMapper;
import pl.com.coders.libria1.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public Iterable<Category> getAllCat() {
        return categoryRepository.findAll();
    }

    public CategoryView getCat(Long id) {
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        Category category = categoryOpt.orElseThrow(() -> new IllegalArgumentException("Category not exist with id : " + id));
        return categoryMapper.toView(category);
    }

    public CategoryView saveCat(CategoryCreateRequest categoryCreateRequest) {
        Category category = categoryMapper.toEntity(categoryCreateRequest);
        return categoryMapper.toView(categoryRepository.save(category));
    }
}
