/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management;

/**
 *
 * @author HLC_2021
 */
public class Order {
    private String id;
    private String readerId;
    private String borrowDate;
    private String returnDate;
    private String isbn;

    public Order(String readerId, String borrowDate, String returnDate, String isbn) {
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
