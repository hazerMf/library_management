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
    private String id;
    private String requireDay;
    private String requestor;
    private Book book;

    public Request(String id, String requireDay, String requestor, Book book) {
        this.id = id;
        this.requireDay = requireDay;
        this.requestor = requestor;
        this.book = book;
    }

    public String getRequireDay() {
        return requireDay;
    }
    public String getRequestor() {
        return requestor;
    }
    public Book getBook() {
        return book;
    }
    public String getInfoRequest() {
        return String.format(
                "Request ID: %s\nRequire Day: %s\nRequestor: %s\nBook Name: %s",
                id,
                getRequireDay(),
                getRequestor(),
                book.getTitle()
        );
    }
}
