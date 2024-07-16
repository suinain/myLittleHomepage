package Homework;

import java.util.Date;

public class Review {
    private String title;
    private String content;
    private Date createdAt;
    private String author;

    public Review(String title, String content) {
        this(title, content, new Date(), "익명의 작가");
    }
    public Review(String title, String content, String author) {
        this(title, content, new Date(), author);
    }

    public Review(String title, String content, Date createdAt, String author) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}

