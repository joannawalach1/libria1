package pl.com.coders.libria1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.coders.libria1.domain.Category;
import pl.com.coders.libria1.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    public Iterable<Category> getAllCat() {
        return categoryRepository.findAll();
    }
}
