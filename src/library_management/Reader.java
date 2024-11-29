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
    private String id;
    private static int idCounter = 1;

    public Reader(String name, String phone, String email) {
        super(name, phone, email);
        this.id = String.format("R%d", idCounter++);
    }

    public String getId() {
        return id;
    }

    public int getFine() {
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
}
