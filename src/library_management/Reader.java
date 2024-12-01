package library_management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Reader extends User {
    private int fine;
    private String id;

    public Reader(String name, String phone, String email) {
        super(name, phone, email);
        this.id = String.format("R%02d", updateId());
    }
    
    private int updateId(){
        int inx = 1;
        ArrayList<Integer> index = null;
        synchronized (this) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("ReaderIndex.in"))) {
                // Lấy data từ file
                index = (ArrayList<Integer>) input.readObject();
            } catch (IOException | ClassNotFoundException e) {
                index = new ArrayList<>(); // Khởi tạo danh sách rỗng nếu không đọc được file
            }
            // Kiểm tra và tìm khoảng trống
            if (index.isEmpty()) {
                inx = 1;
            } else {
                for (int i = 1; i < index.size(); i++) {
                    if (index.get(i) - index.get(i - 1) > 1) {
                        inx = index.get(i - 1) + 1;
                        break;
                    }
                }
                if (inx == 1) inx = index.get(index.size() - 1) + 1; // Nếu không có khoảng trống
            }
            // Chèn inx vào danh sách và giữ danh sách sắp xếp
            int pos = Collections.binarySearch(index, inx);
            if (pos < 0) pos = -pos - 1;
            index.add(pos, inx);

            // Ghi danh sách index vào file
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ReaderIndex.in"))) {
                out.writeObject(index);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inx;
    }

    public String getId() {
        return id;
    }
    // Chuyen thanh getTotalFine
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
    
    public int getFineOrder(String orderId) {
        int fineOrder = 0;
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ArrayList<Order> orders = (ArrayList<Order>) input.readObject();
            for (Order order : orders) {
                if (order.getReaderId().equals(this.getId()) && orderId.equals(order.getId())) {
                    LocalDate currentDate = LocalDate.now();
                    LocalDate returnDate = LocalDate.parse(order.getReturnDate(), formatter);
                    long daysLate = ChronoUnit.DAYS.between(returnDate, currentDate);
                    if (daysLate > 0) {
                        fineOrder += daysLate * 10000;
                    }
                }
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return fineOrder;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}
