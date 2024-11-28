/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management;

import java.io.Serializable;

/**
 *
 * @author HLC_2021
 */
public class User implements IUser, Serializable {
    private String id;
    private String name;
    private String phone;
    private String email;
    private static int idCounter = 1;

    public User(String name, String phone, String email) {
        this.id = String.format("U%d", idCounter++);
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

   
    @Override
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

}
