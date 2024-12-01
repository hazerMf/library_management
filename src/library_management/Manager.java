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
    public Manager(String name, String phone, String email) {
        super(name, phone, email);
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
        
    // Thêm tham số currentDate để hiển thị tiền phạt hiện tại
    public void readerList(){
        try {
            ArrayList<Reader> reader_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"))) {
                reader_list = (ArrayList<Reader>) input.readObject();
            }
            for (Reader reader : reader_list) {
                System.out.printf("%s %s %s %s %d\n", reader.getId(), reader.getName(), reader.getPhone(), reader.getEmail(), reader.getFine());
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void readerInfo(String id){
        // In ra toàn bộ danh sách cuốn sách
        try {
            ArrayList<Reader> reader_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("READER.in"))) {
                reader_list = (ArrayList<Reader>) input.readObject();
            }
            for (Reader reader : reader_list) {
                if(reader.getId().equals(id)){
                    System.out.printf("%s %s %s %s %d", reader.getId(), reader.getName(), reader.getPhone(), reader.getEmail(), reader.getFine());
                }
                return;
            }
            System.out.println("Reader not found!");
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
    
    public void bookInfo(String isbn){
        // In ra toàn bộ danh sách cuốn sách
        try {
            ArrayList<Book> book_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"))) {
                book_list = (ArrayList<Book>) input.readObject();
            }
            for (Book book : book_list) {
                if(book.getIsbn().equals(isbn)){
                    System.out.printf("%s %s %s %s %d", book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getBookNumber());
                }
                return;
            }
            System.out.println("Book not found!");
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void orderList(){
        // In ra toàn bộ danh sách đơn mượn
        try {
            ArrayList<Order> order_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))) {
                order_list = (ArrayList<Order>) input.readObject();
            }
            for (Order order : order_list) {
                System.out.printf("%s %s %s %s %s\n", order.getId(), order.getReaderId(), order.getBorrowDate(), order.getReturnDate(), order.getIsbn());
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void searchBook(String title){
        try {
            ArrayList<Book> book_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("BOOK.in"))) {
                book_list = (ArrayList<Book>) input.readObject();
            }
            
            for (Book book : book_list) {
                if(book.getTitle().equals(title)){
                    System.out.printf("%s %s %s %s %d\n", book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getBookNumber());
                }
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void orderInfo(String id){
        try {
            ArrayList<Order> order_list;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))) {
                order_list = (ArrayList<Order>) input.readObject();
            }
            for (Order order : order_list) {
                if(id.equals(order.getId())){
                    System.out.printf("%s %s %s %s %s", order.getId(), order.getReaderId(), order.getBorrowDate(), order.getReturnDate(), order.getIsbn());
                }
            }
        } 
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
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
