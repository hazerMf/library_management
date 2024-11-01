/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management;

/**
 *
 * @author HLC_2021
 */
public class Loan {
    private String id;
    private String borrowDate;
    private String returnDate;
    private Book book;
    private int excessiveDay;
    private int fine;

    public Loan(String id, String borrowDate, String returnDate, Book book) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.book = book;
    }

    public String getBorrowDate() {
        return borrowDate;
    }
    public String getReturnDate() {
        return returnDate;
    }
    public int getExcessiveDay() {
        return excessiveDay;
    }
    public int getFine() {
        return fine;
    }
    public String getInfoLoan() {
        return String.format(
                "Loan ID: %s\nBorrow Date: %s\nReturn Date: %s\nBook Title: %s\nExcessive Days: %d\nFine: %d",
                id,
                getBorrowDate(),
                getReturnDate(),
                book.getTitle(),
                getExcessiveDay(),
                getFine()
        );
    }
}
