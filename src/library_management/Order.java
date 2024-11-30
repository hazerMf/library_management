package library_management;

import java.io.Serializable;

public class Order implements Serializable {
    private String id;
    private String readerId;
    private String borrowDate;
    private String returnDate;
    private String isbn;
    private static int idCounter = 1;

    public Order(String readerId, String borrowDate, String returnDate, String isbn) {
        this.id = String.format("O%d", idCounter++);
        this.readerId = readerId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isbn = isbn;
    }

    
    public String getId() {
        return id;
    }

    public String getReaderId() {
        return readerId;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBorrowDate() {
        return borrowDate;
    }
    
    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    public String getReturnDate() {
        return returnDate;
    }
    
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    
}
