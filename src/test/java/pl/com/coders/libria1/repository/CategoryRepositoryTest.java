package pl.com.coders.libria1.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import pl.com.coders.libria1.domain.Category;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findByTitle() {
        Category category = new Category();
        category.setCategoryTitle("DOM");
        testEntityManager.persist(category);
        testEntityManager.flush();

        Category foundCategory = categoryRepository.findByCategoryTitle("DOM");
        assertThat(foundCategory.getCategoryTitle()).isEqualTo(category.getCategoryTitle());

    }
}