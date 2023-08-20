package pl.com.coders.libria1.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoryTitle")
    private String categoryTitle;

    public Category(Long id, String categoryTitle) {
        this.id = id;
        this.categoryTitle = categoryTitle;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(categoryTitle, category.categoryTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryTitle);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryTitle='" + categoryTitle + '\'' +
                '}';
    }
}

