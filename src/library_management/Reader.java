/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management;

/**
 *
 * @author HLC_2021
 */
public class Reader extends User {
    private String genreFavorite;

    
    public Reader(String id, String name, String phone, String email, String address, String genreFavorite) {
        super(id, name, phone, email, address);
        this.genreFavorite = genreFavorite;
    }

    
    public String getGenreFavorite() {
        return genreFavorite;
    }

    public void setGenreFavorite(String genreFavorite) {
        this.genreFavorite = genreFavorite;
    }
    
    public void createOrder(Database database) {
        
    }
    
    public void deleteOrder(Database database) {
        
    }
    
    public void createRequest(Database database) {
        
    }
    
    public void deleteRequest(Database database) {
        
    }
    
    public void fineDetail(Order order) {
        System.out.println(order.getExcessiveDay() + " " + order.getFine());
    }
}
