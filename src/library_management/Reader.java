/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HLC_2021
 */
public class Reader extends User {
    private int fine;

    public Reader(String name, String phone, String email) {
        super(name, phone, email);
    }

    
    public int getFine(String currentDate) {
        fine = 0;
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            ArrayList<Order> orders = (ArrayList<Order>) input.readObject();
            for (Order order : orders) {
                if (order.getReaderId().equals(this.getId())) {
                    try {
                        Date current = new Date();
                        Date reDate = sdf.parse(order.getReturnDate());

                        int distance = (int) ((current.getTime() - reDate.getTime()) / (1000 * 60 * 60 * 24));
                        if(distance > 0) {
                            fine += distance * 10000;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public void addOrder(Order order){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Order.txt", true))){
            writer.write(order.getId() + " " + order.getIsbn() + " " + order.getBorrowDate() 
                    + " " + order.getReturnDate() + " " + order.getReaderId());
            writer.newLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void deleteOrder(Order order){
        String s = order.getId() + " " + order.getIsbn() + " " + order.getBorrowDate() 
                    + " " + order.getReturnDate() + " " + order.getReaderId();
        
        try{
            // Tạo ArrayList để lưu những đơn mượn không muốn xóa
            ArrayList<String> l = new ArrayList<>();
            try(BufferedReader reader = new BufferedReader(new FileReader("Order.txt"))){
                String line;
                while((line = reader.readLine()) != null){
                    // Chỉ thêm những sách không muốn xóa
                    if(!line.trim().equals(s)){
                        l.add(line);
                    }
                }
            }
            // BufferedWriter khi không có tham số true sẽ xóa toàn bộ file cũ rồi ghi lại
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Book.txt"))){
                // Ghi lại những đơn mượn được lưu trong ArrayList vào file 
                for(String i : l){
                    writer.write(i);
                    writer.newLine();
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public void orderList(){
        // In ra toàn bộ danh sách đơn mượn
        try(BufferedReader read = new BufferedReader(new FileReader("Order.txt"))){
            String line;
            while((line = read.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
