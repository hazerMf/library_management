package library_management;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

public class Reader extends User {
    private int fine; // Bien luu tong so tien phat cua nguoi dung, tinh tong so tien phat dua tren (ngay hien tai - han tra sach) * 10000
    private String id; // ID cua Reader

    // Constructor
    public Reader(String name, String phone, String email) {
        super(name, phone, email);
        this.id = String.format("R%02d", updateId()); // Mot nguoi dung se co 1 ID nhu sau: "R + bien chi so ham updateId()"
    }
    
    // Ham tao ID cho Reader moi
    private int updateId(){
        int inx = 1; // Bien luu chi so
        
        // Trich xuat ArrayList<Integer> tu file nhi phan ReaderIndex.in luu vao index
        ArrayList<Integer> index = null;
        synchronized (this) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("ReaderIndex.in"))) {
                // Lay data tu file
                index = (ArrayList<Integer>) input.readObject();
            } catch (IOException | ClassNotFoundException e) {
                index = new ArrayList<>(); // Khoi tao danh sach rong neu khong doc duoc file
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

    // Ham encap tra ve ID Readerer
    public String getId() {
        return id;
    }
    
    // Ham tra ve tong so tien phat cua Reader
    public int getTotalFine() {
        fine = 0;
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Khoi tao 1 class DateTimeFormatter theo kieu dd/MM/yyyy
            ArrayList<Order> orders = (ArrayList<Order>) input.readObject(); // Doc ArrayList<Order> tu ORDER.in
            
            // Duyet tung Order trong orders, neu co Order trung ID cua Reader voi ID cua Reader dang xet thi thuc hien tinh tien phat theo cong thuc: (ngay hien tai - han tra sach) * 10000
            for (Order order : orders) {
                if (order.getReaderId().equals(this.getId())) {
                    LocalDate currentDate = LocalDate.now(); // Thoi gian hien tai
                    LocalDate returnDate = LocalDate.parse(order.getReturnDate(), formatter); // Han tra sach
                    long daysLate = ChronoUnit.DAYS.between(returnDate, currentDate);
                    if (daysLate > 0) { // Neu ma tong so ngay tra sach muon lon hon 0 thi moi tinh tien phat
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
    
    // Ham tra ve so tien phat cua Reader theo mot don cu the
    public int getFineOrder(String orderId) {
        int fineOrder = 0;
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Khoi tao 1 class DateTimeFormatter theo kieu dd/MM/yyyy
            ArrayList<Order> orders = (ArrayList<Order>) input.readObject(); // Doc ArrayList<Order> tu ORDER.in
            
            // Duyet tung Order trong orders
            for (Order order : orders) {
                
                // Neu co Order trung ID cua Reader voi ID cua Reader dang xet va trung ID voi ID cua Order dang xet thi thuc hien tinh tien phat theo cong thuc: (ngay hien tai - han tra sach) * 10000
                if (order.getReaderId().equals(this.getId()) && orderId.equals(order.getId())) {
                    LocalDate currentDate = LocalDate.now(); // Ngay hien tai
                    LocalDate returnDate = LocalDate.parse(order.getReturnDate(), formatter); // Han tra sach
                    long daysLate = ChronoUnit.DAYS.between(returnDate, currentDate);
                    if (daysLate > 0) { // Neu ma tong so ngay tra sach muon lon hon 0 thi moi tinh tien phat
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

    // Ham encap thay doi tong so tien phat cua Reader
    public void setFine(int fine) {
        this.fine = fine;
    }
}
