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
public class Manager extends User{
    private String position;
    private int salary;

    
    public Manager(String id, String name, String phone, String email, String address, String position, int salary) {
        super(id, name, phone, email, address);
        this.position = position;
        this.salary = salary;
    }

    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public void createReader(Database database) {
        
    }
    
    public void deleteReader(Database database) {
        
    }
    
    public void createBook(Database database) {
        
    }
    
    public void deleteBook(Database database) {
        
    }
    
    public void checkReaderDetail(Database database) {
        
    }
    
    public void checkNumberBook(Database database) {
        
    }
    
    public void checkNumberUser(Database database) {
        
    }
}
