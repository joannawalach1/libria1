package pl.com.coders.libria1.controller;

public class CategoryCreateRequest {

    private String categoryTitle;

    public CategoryCreateRequest(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public CategoryCreateRequest() {
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
