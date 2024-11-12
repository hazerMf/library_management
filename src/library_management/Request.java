/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management;

/**
 *
 * @author HLC_2021
 */
public class Request {
    private final String id;
    private String requireDate;
    private Reader requestor;
    private Book book;

    
    public Request(String id, String requireDate, Reader requestor, Book book) {
        this.id = id;
        this.requireDate = requireDate;
        this.requestor = requestor;
        this.book = book;
    }

    
    public String getRequireDate() {
        return requireDate;
    }
    
    public void setRequireDate(String requireDate) {
        this.requireDate = requireDate;
    }
    
    public Reader getRequestor() {
        return requestor;
    }
    
    public void setRequestor(Reader requestor) {
        this.requestor = requestor;
    }
    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    public String getInfoRequest() {
        return String.format(
                "Request ID: %s\nRequire Day: %s\nRequestor: %s\nBook Name: %s",
                id,
                getRequireDate(),
                getRequestor().getName(),
                book.getTitle()
        );
    }
}
