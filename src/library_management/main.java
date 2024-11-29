/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library_management;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here
//        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("READER.in"));
//        ArrayList<Reader> test = new ArrayList<>();
//        output.writeObject(test);
//        output.close();
//        
//        ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"));
//        test = (ArrayList<Reader>) input.readObject();
//        System.out.println("Initial empty list test:");
//        if (test.isEmpty()) {
//            System.out.println("Empty list");
//        }
//        input.close();
//        
//        output = new ObjectOutputStream(new FileOutputStream("READER.in"));
//        test = new ArrayList<>();
//        test.add(new Reader("A", "0981", "a@email"));
//        test.add(new Reader("B", "0982", "b@email"));
//        test.add(new Reader("C", "0983", "c@email"));
//        output.writeObject(test);
//        output.close();
//        input = new ObjectInputStream(new FileInputStream("READER.in"));
//        ArrayList<Reader> in = (ArrayList<Reader>) input.readObject();
//        System.out.println("Initial test:");
//        for (Reader x : in) {
//            Reader read = x;
//            System.out.printf("%s %s %s %s\n", read.getId(), read.getName(), read.getPhone(), read.getEmail());
//        }
//        String removeId = "U2";
//        for (int i = 0; i < in.size(); i++) {
//            if (in.get(i).getId().equals(removeId)) {
//                in.remove(i);
//                break;
//            }
//        }
//        System.out.println("After remove:");
//        for (Reader x : in) {
//            Reader read = x;
//            System.out.printf("%s %s %s %s\n", read.getId(), read.getName(), read.getPhone(), read.getEmail());
//        }
//        input.close();
//        output = new ObjectOutputStream(new FileOutputStream("READER.in"));
//        output.writeObject(in);
//        System.out.println("After remove input to file test:");
//        for (Reader x : in) {
//            Reader read = x;
//            System.out.printf("%s %s %s %s\n", read.getId(), read.getName(), read.getPhone(), read.getEmail());
//        }
//        in.add(new Reader("B", "0982", "b@email"));
//        System.out.println("After adding:");
//        for (Reader x : in) {
//            Reader read = x;
//            System.out.printf("%s %s %s %s\n", read.getId(), read.getName(), read.getPhone(), read.getEmail());
//        }
//        output.close();
//        output = new ObjectOutputStream(new FileOutputStream("READER.in"));
//        output.writeObject(in);
//        System.out.println("After adding input to file test:");
//        for (Reader x : in) {
//            Reader read = x;
//            System.out.printf("%s %s %s %s\n", read.getId(), read.getName(), read.getPhone(), read.getEmail());
//        }
//        output.close();


//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Date current = new Date();
//            Date test = sdf.parse("20/11/2021");
//            int distance = (int) ((current.getTime() - test.getTime()) / (1000 * 60 * 60 * 24));
//            System.out.println(distance);
//            current = sdf.parse("20/11/2023");
//            distance = (int) ((current.getTime() - test.getTime()) / (1000 * 60 * 60 * 24));
//            System.out.println(distance);
//
//        } catch (ParseException e) {
//            
//        }
        

//        ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"));
//        ArrayList<Reader> tmp = (ArrayList<Reader>) input.readObject();
//        for (Reader x : tmp) {
//            System.out.printf("%s %s %s %s\n", x.getId(), x.getName(), x.getPhone(), x.getEmail());
//        }
//        input.close();


//        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("READER.in"));
//        ArrayList<Reader> tmp = new ArrayList<Reader>();
//        output.writeObject(tmp);
//        output.close();
//        
//        ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"));
//        tmp = (ArrayList<Reader>) input.readObject();
//        if (tmp.isEmpty()) {
//            System.out.println("Is empty");
//        }
//        input.close();   

//        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("BOOK.in"));
//        ArrayList<Book> tmp = new ArrayList<Book>();
//        output.writeObject(tmp);
//        output.close();
//        
//        ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"));
//        tmp = (ArrayList<Book>) input.readObject();
//        if (tmp.isEmpty()) {
//            System.out.println("Is empty");
//        }
//        input.close(); 


//        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("ORDER.in"));
//        ArrayList<Order> tmp = new ArrayList<Order>();
//        output.writeObject(tmp);
//        output.close();
//        
//        ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"));
//        tmp = (ArrayList<Order>) input.readObject();
//        if (tmp.isEmpty()) {
//            System.out.println("Is empty");
//        }
//        input.close();


//        Reader read = new Reader("A", "B", "C");
//        System.out.println(read.getId());
//        System.out.println("Fine Initial: " + read.getFine());
//        
//        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("ORDER.in"));
//        ArrayList<Order> tmp = new ArrayList<Order>();
//        tmp.add(new Order("R1", "21/10/2024", "27/11/2024", "10000"));
//        tmp.add(new Order("R2", "21/10/2024", "27/11/2024", "10000"));
//        tmp.add(new Order("R1", "22/10/2024", "28/11/2024", "10001"));
//        output.writeObject(tmp);
//        output.close();
//        
//        ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"));
//        tmp = (ArrayList<Order>) input.readObject();
//        if (tmp.isEmpty()) {
//            System.out.println("Is empty");
//        } else {
//            System.out.println("List of orders:");
//            for (Order x : tmp) {
//                System.out.println(x.getId() + " " + x.getReaderId() + " " + x.getBorrowDate() + " " + x.getReturnDate() + " " + x.getIsbn());
//                
//            }
//        }
//        input.close();
//        
//        System.out.println("Fine After Inputting order: " + read.getFine());
        
    }
    
}
