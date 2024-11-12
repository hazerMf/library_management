/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management;

/**
 *
 * @author HLC_2021
 */
public class User {
    private final String id;
    private final String name;
    private String phone;
    private String email;
    private String address;

    
    public User(String id, String name, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfoUser() {
        return String.format(
                "ID: %s\nName: %s\nPhone: %s\nEmail: %s\nAddress: %s",
                getId(),
                getName(),
                getPhone(),
                getEmail(),
                getAddress()
        );
    }
    
    public void seeBookList(Database database) {
        database.showBookList();
    }
}
