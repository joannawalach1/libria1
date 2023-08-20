package pl.com.coders.libria1.controller;

public class BookUpdateRequest {
    private String title;
    private String author;
    private int amount;

    public BookUpdateRequest(String newTitle, String newAuthor, int i) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
