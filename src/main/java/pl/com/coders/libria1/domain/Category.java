package pl.com.coders.libria1.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryTitle;

    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();


    public Category(Long id, String categoryTitle, List<Book> books) {
        this.id = id;
        this.categoryTitle = categoryTitle;
        this.books = books;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(categoryTitle, category.categoryTitle) && Objects.equals(books, category.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryTitle, books);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryTitle='" + categoryTitle + '\'' +
                ", books=" + books +
                '}';
    }
}

