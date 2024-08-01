package AboutJAVA.Library;

import java.time.LocalDateTime;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private LocalDateTime published;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getPublished() {
        return published;
    }

    public void setPublished(LocalDateTime published) {
        this.published = published;
    }

    public Book(String title, String author, String isbn, LocalDateTime published) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.published = published;
    }
}