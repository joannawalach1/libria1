package pl.com.coders.libria1.controller;

import pl.com.coders.libria1.domain.Category;

import java.time.LocalDateTime;

public class BookView {
    private Long id;
    private String title;
    private String author;
    private int amount;

    private LocalDateTime created;
    private LocalDateTime updated;

    public BookView(Long id, String title, String author, int amount, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.amount = amount;
        this.created = created;
        this.updated = updated;
    }

    public BookView() {
    }

    public BookView(Category category, String title, String author, int amount, LocalDateTime created, LocalDateTime updated) {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public void setCategory(Category category) {
    }


    public Long getCategory() {
        return getCategory();
    }
}
