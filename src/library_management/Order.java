package library_management;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Order implements Serializable {
    private String id; // ID cua Order
    private String readerId; // ID cua Reader dang muon
    private String borrowDate; // Ngay muon sach
    private String returnDate; // Han tra sach
    private String isbn; // Ma ISBN cua sach dang muon

    public Order(String readerId, String borrowDate, String returnDate, String isbn) {
        this.id = String.format("O%02d", updateId()); // Mot Order se co 1 ID nhu sau: "O + bien chi so ham updateId()"
        this.readerId = readerId; 
        this.borrowDate = borrowDate; 
        this.returnDate = returnDate; 
        this.isbn = isbn; 
    }
    
    // Ham tao ID cho Order moi
    private int updateId(){
        int inx = 1; // Bien luu chi so
        ArrayList<Integer> index = null;
        synchronized (this) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("OrderIndex.in"))) {
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
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("OrderIndex.in"))) {
                out.writeObject(index);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inx;
    }

    // Ham encap tra ve ID Order
    public String getId() {
        return id;
    }

    // Ham encap tra ve ID cua Reader dang muon
    public String getReaderId() {
        return readerId;
    }

    // Ham encap tra ve ma ISBN cua sach dang muon
    public String getIsbn() {
        return isbn;
    }

    // Ham encap tra ve ngay muon sach
    public String getBorrowDate() {
        return borrowDate;
    }
    
    // Ham encap thay doi ngay muon sach
    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    // Ham encap tra ve han tra sach
    public String getReturnDate() {
        return returnDate;
    }
    
    // Ham encap thay doi han tra sach
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    
}
