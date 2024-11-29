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
//        test.add(new Reader("A", "0981", "a@email"));
//        test.add(new Reader("B", "0982", "b@email"));
//        test.add(new Reader("C", "0983", "c@email"));
//        Reader reader = test.get(0);
//        output.writeObject(test);
//        ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"));
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
//        output = new ObjectOutputStream(new FileOutputStream("READER.in"));
//        output.writeObject(in);
//        System.out.println("After adding input to file test:");
//        for (Reader x : in) {
//            Reader read = x;
//            System.out.printf("%s %s %s %s\n", read.getId(), read.getName(), read.getPhone(), read.getEmail());
//        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date current = new Date();
            Date test = sdf.parse("20/11/2021");
            int distance = (int) ((current.getTime() - test.getTime()) / (1000 * 60 * 60 * 24));
            System.out.println(distance);
            current = sdf.parse("20/11/2023");
            distance = (int) ((current.getTime() - test.getTime()) / (1000 * 60 * 60 * 24));
            System.out.println(distance);

        } catch (ParseException e) {
            
        }
        // comment5asdhaoisdn
        
    }
    
}
