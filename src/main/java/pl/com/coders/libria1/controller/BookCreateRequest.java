package pl.com.coders.libria1.controller;

import java.time.LocalDateTime;

public class BookCreateRequest {

    private Long id;
    private String title;
    private String author;
    private int amount;
    private LocalDateTime created;
    private LocalDateTime updated;

    public BookCreateRequest(Long id, String title, String author, int amount, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.amount = amount;
        this.created = created;
        this.updated = updated;
    }

    public BookCreateRequest() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
