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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ArrayList<Order> orders = (ArrayList<Order>) input.readObject();
            for (Order order : orders) {
                if (order.getReaderId().equals(this.getId())) {
                    LocalDate currentDate = LocalDate.now();
                    LocalDate returnDate = LocalDate.parse(order.getReturnDate(), formatter);
                    long daysLate = ChronoUnit.DAYS.between(returnDate, currentDate);
                    if (daysLate > 0) {
                        fine += daysLate * 10000;
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
