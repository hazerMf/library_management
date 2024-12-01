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
import java.util.ArrayList;

public class Manager extends User{
    private String id;

    public Manager(String id, String name, String phone, String email) {
        super(name, phone, email);
        this.id = id;
    }
    
    public Manager(String name, String phone, String email) {
        super(name, phone, email);
    }

    public String getId() {
        return id;
    }
    
    public void addBook(Book book){
        try {
            ArrayList<Book> book_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"))) {
                book_list = (ArrayList<Book>) input.readObject();
            }
            book_list.add(book);
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("BOOK.in"))) {
                output.writeObject(book_list);
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void deleteBook(String isbn){
        try {
            ArrayList<Book> book_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"))) {
                book_list = (ArrayList<Book>) input.readObject();
            }
            for (int i = 0; i < book_list.size(); i++) {
                if (book_list.get(i).getIsbn().equals(isbn)) {
                    book_list.remove(i);
                    break;
                }
            }
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("BOOK.in"))) {
                output.writeObject(book_list);
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void addReader(Reader reader){
        try {
            ArrayList<Reader> reader_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"))) {
                reader_list = (ArrayList<Reader>) input.readObject();
            }
            reader_list.add(reader);
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("READER.in"))) {
                output.writeObject(reader_list);
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void deleteReader(String id){
        try {
            ArrayList<Reader> reader_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"))) {
                reader_list = (ArrayList<Reader>) input.readObject();
            }
            for (int i = 0; i < reader_list.size(); i++) {
                if (reader_list.get(i).getId().equals(id)) {
                    reader_list.remove(i);
                    break;
                }
            }
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("READER.in"))) {
                output.writeObject(reader_list);
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void addOrder(Order order){
        try {
            ArrayList<Order> order_list;
            ArrayList<Book> book_list;
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"));
            order_list = (ArrayList<Order>) input.readObject();
            input = new ObjectInputStream(new FileInputStream("BOOK.in"));
            book_list = (ArrayList<Book>) input.readObject();
            input.close();
            for (Book book : book_list) {
                if (book.getIsbn().equals(order.getIsbn())) {
                    book.setBookNumber(book.getBookNumber() - 1);
                    order_list.add(order);
                }
            }
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("ORDER.in"));
            output.writeObject(order_list);
            output = new ObjectOutputStream(new FileOutputStream("BOOK.in"));
            output.writeObject(book_list);
            output.close();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void deleteOrder(String id){
        try {
            ArrayList<Order> order_list;
            ArrayList<Book> book_list;

            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))) {
                order_list = (ArrayList<Order>) input.readObject();
            }

            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"))) {
                book_list = (ArrayList<Book>) input.readObject();
            }

            Order orderToDelete = null;
            for (Order order : order_list) {
                if (order.getId().equals(id)) {
                    orderToDelete = order;
                    break;
                }
            }

            if (orderToDelete != null) {
                for (Book book : book_list) {
                    if (book.getIsbn().equals(orderToDelete.getIsbn())) {
                        book.setBookNumber(book.getBookNumber() + 1);
                        break;
                    }
                }

                order_list.remove(orderToDelete);

                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("BOOK.in"))) {
                    output.writeObject(book_list);
                }

                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("ORDER.in"))) {
                    output.writeObject(order_list);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //them Manager
    public void addManager(Manager manager){
        try {
            ArrayList<Manager> manager_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("MANAGER.in"))) {
                manager_list = (ArrayList<Manager>) input.readObject();
            }
            manager_list.add(manager);
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("MANAGER.in"))) {
                output.writeObject(manager_list);
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //Xoa Manager
    public void deleteManager(String id){
        try {
            ArrayList<Manager> manager_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("MANAGER.in"))) {
                manager_list = (ArrayList<Manager>) input.readObject();
            }
            for (int i = 0; i < manager_list.size(); i++) {
                if (manager_list.get(i).getId().equals(id)) {
                    manager_list.remove(i);
                    break;
                }
            }
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("MANAGER.in"))) {
                output.writeObject(manager_list);
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Book> bookList(){
        // In ra toàn bộ danh sách cuốn sách
        ArrayList<Book> book_list = null;
        try {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"))) {
                   book_list = (ArrayList<Book>) input.readObject();
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return book_list;
    }
    
    public ArrayList<String> bookIsbnList(){
        // In ra toàn bộ danh sách isbn cuốn sách
        ArrayList<Book> book_list = null;
        ArrayList<String> book_isbn = new ArrayList<>();
        try {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"))) {
                   book_list = (ArrayList<Book>) input.readObject();
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        for(Book i:book_list){
            book_isbn.add(i.getIsbn());
        }
        return book_isbn;
    }
    
    public ArrayList<Reader> readerList(){
        // In ra toàn bộ danh sách reader
        ArrayList<Reader> reader_list = null;
        try {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"))) {
                   reader_list = (ArrayList<Reader>) input.readObject();
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return reader_list;
    }
    
    public ArrayList<String> readerIdList(){
        // In ra toàn bộ danh sách id reader
        ArrayList<Reader> reader_list = null;
        ArrayList<String> reader_id = new ArrayList<>();
        try {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"))) {
                reader_list = (ArrayList<Reader>) input.readObject();
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        for(Reader i:reader_list){
            reader_id.add(i.getId());
        }
        return reader_id;
    }
    
    public ArrayList<Order> orderList(){
        // In ra toàn bộ danh sách order
        ArrayList<Order> order_list = null;
        try {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))) {
                order_list = (ArrayList<Order>) input.readObject();
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return order_list;
    }
    
    public ArrayList<String> orderIdList(){
        // In ra toàn bộ danh sách order id
        ArrayList<Order> order_list = null;
        ArrayList<String> order_id = new ArrayList<>();
        try {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))) {
                order_list = (ArrayList<Order>) input.readObject();
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        for(Order i:order_list){
            order_id.add(i.getId());
        }
        return order_id;
    }
    
    public ArrayList<Manager> managerList(){
        // In ra toàn bộ danh sách manager
        ArrayList<Manager> manager_list = null;
        try {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("MANAGER.in"))) {
                manager_list = (ArrayList<Manager>) input.readObject();
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return manager_list;
    }
    
    public ArrayList<String> managerIdList(){
        // In ra toàn bộ danh sách manager id
        ArrayList<Manager> manager_list = null;
        ArrayList<String> manager_id = new ArrayList<>();
        try {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("MANAGER.in"))) {
                manager_list = (ArrayList<Manager>) input.readObject();
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        for(Manager i:manager_list){
            manager_id.add(i.getId());
        }
        return manager_id;
    }
    
     public Reader getReaderById(String readerId){
        try{
            ArrayList<Reader> readerList;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"))) {
                readerList = (ArrayList<Reader>) input.readObject();
            }
            for (Reader reader : readerList) {
                if (reader.getId().equals(readerId)) {
                    return reader;
                }
            }
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    } 
    
}
