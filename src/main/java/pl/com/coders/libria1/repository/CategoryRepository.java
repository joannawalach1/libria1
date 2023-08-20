package pl.com.coders.libria1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.coders.libria1.domain.Category;

        @Repository
        public interface CategoryRepository extends CrudRepository<Category, Long> {
                Category findByCategoryTitle(String categoryTitle);
        }
