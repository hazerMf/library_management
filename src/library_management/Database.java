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
public class Database {
    private ArrayList<Book> books;
    private ArrayList<Reader> readers;
    private ArrayList<Manager> managers;
    private ArrayList<Order> orders;
    private ArrayList<Request> requests;

    
    public String getInfoLib() {
        return String.format(
                "Number of books: %d\nNumber of readers: %d\nNumber of managers: %d\nNumber of orders: %d\nNumber of requests: %d", 
                books.size(),
                readers.size(),
                managers.size(),
                orders.size(),
                requests.size()
        );
    }
    
    public void addBook(Book book) {
        if (books.contains(book)) {
            System.out.println("This book already exists!");
        } else books.add(book);
    }
    
    public void removeBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
        } else System.out.println("This book does not exist!");
    }
    
    public void showBookList() {
        for (Book book : books) {
            System.out.println(book.getInfoBook());
        }
    }
    
    public void addOrder(Order order) {
        if (orders.contains(order)) {
            System.out.println("This order already exists!");
        } else orders.add(order);
    }
    
    public void removeOrder(Order order) {
        if (orders.contains(order)) {
            orders.remove(order);
        } else System.out.println("This order does not exist!");
    }
    
    public void addRequest(Request request) {
        if (requests.contains(request)) {
            System.out.println("This request already exists!");
        } else requests.add(request);
    }
    
    public void removeRequest(Request request) {
        if (requests.contains(request)) {
            requests.remove(request);
        } else System.out.println("This request does not exist!");
    }
    
    public void addReader(Reader reader) {
        if (readers.contains(reader)) {
            System.out.println("This reader already exists!");
        } else readers.add(reader);
    }
    
    public void removeReader(Reader reader) {
        if (readers.contains(reader)) {
            readers.remove(reader);
        } else System.out.println("This reader does not exist!");
    }
    
    public void addManager(Manager manager) {
        if (managers.contains(manager)) {
            System.out.println("This manager already exists!");
        } else managers.add(manager);
    }
    
    public void removeManager(Manager manager) {
        if (managers.contains(manager)) {
            managers.remove(manager);
        } else System.out.println("This manager does not exist!");
    }
}
