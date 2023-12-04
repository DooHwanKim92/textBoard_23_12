package org.example.wiseSaying;

public class WiseSaying {
    private String content;
    private String author;
    private int id;
    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
    public int getId() {
        return this.id;
    }
    public String getContent() {
        return this.content;
    }
    public String getAuthor() {
        return this.author;
    }
}
