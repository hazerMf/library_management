/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management;

/**
 *
 * @author HLC_2021
 */
public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final String publisher;
    private final String publishDate;
    private float rating;
    private String comment;
    private int copy;

    
    public Book(String isbn, String title, String author, String publisher, String publishDate, float rating, String comment, int copy) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.rating = rating;
        this.comment = comment;
        this.copy = copy;
    }

    
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public String getPublishDate() {
        return publishDate;
    }
    
    public float getRating() {
        return rating;
    }
    
    public String getComment() {
        return comment;
    }
    
    public int getCopy() {
        return copy;
    }
    
    public void rate(float rating) {
        this.rating = rating;
    }
    
    public void addComment(String comment) {
        this.comment = comment;
    }
    
    public void setCopy(int copy) {
        this.copy = copy;
    }

    public String getInfoBook() {
        return String.format(
                "ISBN Number: %s\nTitle: %s\nAuthor: %s\nPublisher: %s\nPublish Date: %s\nRating: %.2f\nComment: %s\nCopies: %d", 
                isbn,
                getTitle(),
                getAuthor(),
                getPublisher(),
                getPublishDate(),
                getRating(),
                getComment(),
                getCopy()
        );
    }
    
}