/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management;

import java.util.ArrayList;

/**
 *
 * @author HLC_2021
 */
public class Manager {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Loan> loans;
    private ArrayList<Request> requests;
    
    public String getInfoLib() {
        return String.format(
                "Book Num: %d\nUser Num: %d\nLoan Num: %d\nRequest Num: %d", 
                books.size(), 
                users.size(), 
                loans.size(), 
                requests.size()
        );
    }
    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }
    public void removeBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
        }
    }
    public void addLoan(Loan loan) {
        if (!loans.contains(loan)) {
            loans.add(loan);
        }
    }
    public void removeLoan(Loan loan) {
        if (loans.contains(loan)) {
            loans.remove(loan);
        }
    }
    public void addRquest(Request request) {
        if (!requests.contains(request)) {
            requests.add(request);
        }
    }
    public void removeRequest(Request request) {
        if (requests.contains(request)) {
            requests.remove(request);
        }
    }
    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }
    public void removeUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
        }
    }
}
