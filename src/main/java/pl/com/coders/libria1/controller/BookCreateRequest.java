package pl.com.coders.libria1.controller;

public class BookCreateRequest {

    private String title;
    private String author;
    private int amount;

    public BookCreateRequest(String title, String author, int amount) {
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
