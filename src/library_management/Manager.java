package library_management;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Manager extends User {
    private String id; // ID cua Manager, tu tao

    // Contructor cho Manager
    public Manager(String id, String name, String phone, String email) {
        super(name, phone, email);
        this.id = id;
    }
    
    // Contructor de tao mot Manager tam thoi, khong co ID de co the truy cap cac method cua Manager
    public Manager(String name, String phone, String email) {
        super(name, phone, email);
    }

    // Ham encap tra ve ID cua Manager
    public String getId() {
        return id;
    }
    
    
    // Su dung cac file nhi phan *.in de chua cac ArrayList luu danh sach cac Object
    
    // Trich xuat ArrayList trong file nhi phan thong qua ObjectInputStream, thuc hien cac thao tac
    // them va xoa Object tren ArrayList va luu lai vao file nhi phan thong qua ObjectOutputStream
    
    
    // Them mot quyen sach vao kho thu vien
    public void addBook(Book book){
        try {
            
            // Trich xuat ArrayList<Book> trong file nhi phan BOOK.in luu vao book_list
            ArrayList<Book> book_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"))) {
                book_list = (ArrayList<Book>) input.readObject();
            }
            
            // Them mot Object Book vao trong book_list
            book_list.add(book);
            
            // Ghi de book_list da thay doi vao file nhi phan thay the ArrayList<Book> truoc do
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("BOOK.in"))) {
                output.writeObject(book_list);
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    // Xoa mot quyen sach khoi kho thu vien
    public void deleteBook(String isbn){
        try {
            
            // Trich xuat ArrayList<Book> trong file nhi phan BOOK.in luu vao book_list
            ArrayList<Book> book_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"))) {
                book_list = (ArrayList<Book>) input.readObject();
            }
            
            // Kiem tra xem co ton tai mot quyen sach co ma ISBN giong voi ma ISBN cua sach minh muon xoa, neu co thi xoa
            for (int i = 0; i < book_list.size(); i++) {
                if (book_list.get(i).getIsbn().equals(isbn)) {
                    book_list.remove(i);
                    break;
                }
            }
            
            // Ghi de book_list da thay doi vao file nhi phan thay the ArrayList<Book> truoc do
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("BOOK.in"))) {
                output.writeObject(book_list);
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    // Them mot nguoi dung
    public void addReader(Reader reader){
        try {
            
            // Trich xuat ArrayList<Reader> trong file nhi phan READER.in luu vao reader_list
            ArrayList<Reader> reader_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"))) {
                reader_list = (ArrayList<Reader>) input.readObject();
            }
            
            // Them mot Object Reader vao trong reader_list
            reader_list.add(reader);
            
            // Ghi de reader_list da thay doi vao file nhi phan thay the ArrayList<Reader> truoc do
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("READER.in"))) {
                output.writeObject(reader_list);
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    // Xoa mot nguoi dung
    public void deleteReader(String id){
        try {
            
            // Trich xuat ArrayList<Reader> trong file nhi phan READER.in luu vao book_list
            ArrayList<Reader> reader_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"))) {
                reader_list = (ArrayList<Reader>) input.readObject();
            }
            
            // Kiem tra xem co ton tai mot Reader co ma ID giong voi ma ID cua Reader minh muon xoa, neu co thi xoa
            for (int i = 0; i < reader_list.size(); i++) {
                if (reader_list.get(i).getId().equals(id)) {
                    reader_list.remove(i);
                    break;
                }
            }
            
            // Ghi de reader_list da thay doi vao file nhi phan thay the ArrayList<Reader> truoc do
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("READER.in"))) {
                output.writeObject(reader_list);
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    // Them mot don muon sach
    public void addOrder(Order order){
        try {
            
            // Trich xuat ArrayList<Order> trong file nhi phan ORDER.in luu vao order_list
            ArrayList<Order> order_list;
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"));
            order_list = (ArrayList<Order>) input.readObject();
            
            // Trich xuat ArrayList<Book> trong file nhi phan BOOK.in luu vao book_list
            ArrayList<Book> book_list;
            input = new ObjectInputStream(new FileInputStream("BOOK.in"));
            book_list = (ArrayList<Book>) input.readObject();
            input.close();
            
            // Kiem tra xem co ton tai mot quyen sach co ma ISBN giong voi ma ISBN trong don muon ma minh muon them vao
            // Neu co thi tru tong so sach trong kho di 1 va them 1 Object Order vao order_list
            for (Book book : book_list) {
                if (book.getIsbn().equals(order.getIsbn())) {
                    book.setBookNumber(book.getBookNumber() - 1);
                    order_list.add(order);
                }
            }
            
            // Ghi de order_list da thay doi vao file nhi phan thay the ArrayList<Order> truoc do
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("ORDER.in"));
            output.writeObject(order_list);
            
            // Ghi de book_list da thay doi vao file nhi phan thay the ArrayList<Order> truoc do
            output = new ObjectOutputStream(new FileOutputStream("BOOK.in"));
            output.writeObject(book_list);
            output.close();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    // Xoa mot don muon
    public void deleteOrder(String id){
        try {
            
            // Trich xuat ArrayList<Order> trong file nhi phan ORDER.in luu vao order_list
            ArrayList<Order> order_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))) {
                order_list = (ArrayList<Order>) input.readObject();
            }

            // Trich xuat ArrayList<Book> trong file nhi phan BOOK.in luu vao book_list
            ArrayList<Book> book_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"))) {
                book_list = (ArrayList<Book>) input.readObject();
            }

            // Tao mot Object Order orderToDelete de luu don muon minh muon xoa
            // Kiem tra xem co ton tai mot don muon co ID giong voi ID cua don muon minh muon xoa khong, neu co gan orderToDelete vao no
            Order orderToDelete = null;
            for (Order order : order_list) {
                if (order.getId().equals(id)) {
                    orderToDelete = order;
                    break;
                }
            }

            // Neu ton tai don muon muon xoa
            if (orderToDelete != null) {
                for (Book book : book_list) {
                    if (book.getIsbn().equals(orderToDelete.getIsbn())) { // Cong so luong sach trong kho len 1 don vi
                        book.setBookNumber(book.getBookNumber() + 1);
                        break;
                    }
                }

                // Xoa Object orderToDelete trong order_list
                order_list.remove(orderToDelete);

                // Ghi de book_list da thay doi vao file nhi phan thay the ArrayList<Book> truoc do
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("BOOK.in"))) {
                    output.writeObject(book_list);
                }

                // Ghi de order_list da thay doi vao file nhi phan thay the ArrayList<Order> truoc do
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("ORDER.in"))) {
                    output.writeObject(order_list);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // Them mot Manager
    public void addManager(Manager manager){
        try {
            
            // Trich xuat ArrayList<Manager> trong file nhi phan MANAGER.in luu vao manager_list
            ArrayList<Manager> manager_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("MANAGER.in"))) {
                manager_list = (ArrayList<Manager>) input.readObject();
            }
            
            // Them mot Object Manager vao trong manager_list
            manager_list.add(manager);
            
            // Ghi de manager_list da thay doi vao file nhi phan thay the ArrayList<Manager> truoc do
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("MANAGER.in"))) {
                output.writeObject(manager_list);
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    // Xoa mot Manager
    public void deleteManager(String id){
        try {
            
            // Trich xuat ArrayList<Manager> trong file nhi phan MANAGER.in luu vao manager_list
            ArrayList<Manager> manager_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("MANAGER.in"))) {
                manager_list = (ArrayList<Manager>) input.readObject();
            }
            
            // Kiem tra xem co ton tai mot quyen sach co ma ISBN giong voi ma ISBN cua sach minh muon xoa, neu co thi xoa
            for (int i = 0; i < manager_list.size(); i++) {
                if (manager_list.get(i).getId().equals(id)) {
                    manager_list.remove(i);
                    break;
                }
            }
            
            // Ghi de manager_list da thay doi vao file nhi phan thay the ArrayList<Manager> truoc do
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("MANAGER.in"))) {
                output.writeObject(manager_list);
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    // Ham tra ve danh sach cac quyen sach trong thu vien
    public ArrayList<Book> bookList(){
        
        // Trich xuat ArrayList<Book> trong file nhi phan BOOK.in luu vao book_list
        ArrayList<Book> book_list = null; 
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"))) {
               book_list = (ArrayList<Book>) input.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return book_list;
    }
    
    // Ham tra ve danh sach cac ma ISBN trong thu vien
    public ArrayList<String> bookIsbnList(){
        
        // Trich xuat ArrayList<Book> trong file nhi phan BOOK.in luu vao book_list
        ArrayList<Book> book_list = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"))) {
               book_list = (ArrayList<Book>) input.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
        // Lay tung ma ISBN cua cac Book trong book_list luu vao book_isbn
        ArrayList<String> book_isbn = new ArrayList<>();
        for(Book i:book_list){
            book_isbn.add(i.getIsbn());
        }
        return book_isbn;
    }
    
    // Ham tra ve danh sach cac Reader trong thu vien
    public ArrayList<Reader> readerList(){
        
        // Trich xuat ArrayList<Reader> trong file nhi phan READER.in luu vao reader_list
        ArrayList<Reader> reader_list = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"))) {
               reader_list = (ArrayList<Reader>) input.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return reader_list;
    }
    
    // Ham tra ve danh sach cac ID cua Reader trong thu vien
    public ArrayList<String> readerIdList(){
        
        // Trich xuat ArrayList<Reader> trong file nhi phan READER.in luu vao reader_list
        ArrayList<Reader> reader_list = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"))) {
            reader_list = (ArrayList<Reader>) input.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
        // Lay tung ID cua cac Reader trong reader_list luu vao reader_id
        ArrayList<String> reader_id = new ArrayList<>();
        for(Reader i:reader_list){
            reader_id.add(i.getId());
        }
        return reader_id;
    }
    
    // Ham tra ve danh sach cac don muon
    public ArrayList<Order> orderList(){
        
        // Trich xuat ArrayList<Order> trong file nhi phan ORDER.in luu vao order_list
        ArrayList<Order> order_list = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))) {
            order_list = (ArrayList<Order>) input.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return order_list;
    }
    
    // Ham tra ve danh sach ID cua cac don muon
    public ArrayList<String> orderIdList(){
        
        // Trich xuat ArrayList<Order> trong file nhi phan ORDER.in luu vao order_list
        ArrayList<Order> order_list = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))) {
            order_list = (ArrayList<Order>) input.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
        // Lay tung ID cua cac don muon trong order_list luu vao order_id
        ArrayList<String> order_id = new ArrayList<>();
        for(Order i:order_list){
            order_id.add(i.getId());
        }
        return order_id;
    }
    
    // Ham tra ve danh sach cac Manager trong thu vien
    public ArrayList<Manager> managerList(){
        
        // Trich xuat ArrayList<Manager> trong file nhi phan MANAGER.in luu vao manager_list
        ArrayList<Manager> manager_list = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("MANAGER.in"))) {
            manager_list = (ArrayList<Manager>) input.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return manager_list;
    }
    
    // Ham tra ve danh sach ID cua cac Manager trong thu vien
    public ArrayList<String> managerIdList(){
        
        // Trich xuat ArrayList<Manager> trong file nhi phan MANAGER.in luu vao manager_list
        ArrayList<Manager> manager_list = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("MANAGER.in"))) {
            manager_list = (ArrayList<Manager>) input.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
        // Lay tung ID cua cac Manager trong manager_list luu vao manager_id
        ArrayList<String> manager_id = new ArrayList<>();
        for(Manager i:manager_list){
            manager_id.add(i.getId());
        }
        return manager_id;
    }
    
    // Ham tim Reader bang cach nhap ID
    public Reader getReaderById(String readerId){
        
        // Trich xuat ArrayList<Reader> trong file nhi phan READER.in luu vao reader_list
        ArrayList<Reader> readerList = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"))) {
            readerList = (ArrayList<Reader>) input.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // Kiem tra xem neu ton tai mot Reader co ID bang ID cua Reader minh muon tim, neu co ham tra ve Reader do
        for (Reader reader : readerList) {
            if (reader.getId().equals(readerId)) {
                return reader;
            }
        }
        return null;
    } 
    
}
