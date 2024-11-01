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
    private String name;
    private String phone;
    private String email;
    private String address;

    public User(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public String getInfoUser() {
        return String.format(
                "Name: %s\nPhone: %s\nEmail: %s\nAddress: %s",
                getName(),
                getPhone(),
                getEmail(),
                getAddress()
        );
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
}
