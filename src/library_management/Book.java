package library_management;

import java.io.Serializable;

public class Book implements Serializable {
    private final String isbn; // Ma ISBN(International Standard Book Number) cho quyen sach
    private final String title; // Ten quyen sach
    private final String author; // Tac gia quyen sach
    private final String publisher; // Nha xuat ban quyen sach
    private int bookNumber; // So luong quyen sach thu vien dang co trong kho

    // Contructor cho Book
    public Book(String isbn, String title, String author, String publisher) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    // Ham encap tra ve so luong sach trong kho
    public int getBookNumber() {
        return bookNumber;
    }

    // Ham encap thay doi so luong sach trong kho
    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    // Ham encap tra ve ma ISBN quyen sach
    public String getIsbn() {
        return isbn;
    }
    
    // Ham encap tra ve ten quyen sach
    public String getTitle() {
        return title;
    }
    
    // Ham encap tra ve tac gia
    public String getAuthor() {
        return author;
    }
    
    // Ham encap tra ve nha xuat ban
    public String getPublisher() {
        return publisher;
    }

}