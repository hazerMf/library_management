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

public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
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
        
        
        LoginFrame lgf = new LoginFrame();
        lgf.setTitle("Log in");
        lgf.setVisible(true);
        lgf.setSize(854,480);
        lgf.setResizable(false);
        lgf.setLocationRelativeTo(null);

//        LoginFrame lgf = new LoginFrame();
//        lgf.setTitle("Log in");
//        lgf.setVisible(true);
//        lgf.setSize(854,480);
//        lgf.setLocationRelativeTo(null);

          Manager admin = new Manager("Nguyen Tuan Minh", "0367305736", "gemeuacong2907@gmail.com");
          // test add Book
//          Book b1 = new Book("000-001", "Qua den", "Nguyen Tuan Minh", "Kim Dong");
//          b1.setBookNumber(10);
//          Book b2 = new Book("000-002", "Toan 12", "Quang Hai", "Bo giao duc");
//          b2.setBookNumber(20);
//          Book b3 = new Book("000-003", "So tay Sinh vien", "Ngo Ha", "Hoc vien Ptit");
//          b3.setBookNumber(1000);
//          
//          admin.addBook(b1);
//          admin.addBook(b2);
//          admin.addBook(b3);
//          admin.bookList();
          
          //Test delete Book
//          admin.deleteBook("000-002");
//          admin.bookList();
          
            //Test add Reader
//          Reader r1 = new Reader("Nguyen Viet Hoang", "0123456789", "vh2004@gmail.com");
//          Reader r2 = new Reader("Tran Tuan Cuong", "0987654321", "tc1292@gmail.com");
//          Reader r3 = new Reader("Tran Minh Hieu", "012122332", "mh9826@gmail.com");
//          Reader r4 = new Reader("Ngo Ba Kha", "909384932", "bk@gmail.com");
//          admin.addReader(r1);
//          admin.addReader(r2);
//          admin.addReader(r3);
//          admin.addReader(r4);
//          admin.readerList();
          
          //Test delete Reader
//          admin.deleteReader("R1");
//          admin.readerList();
          
            //Test add Order
//          Order o1 = new Order("R2", "20/11/2024", "27/11/2024", "000-001");
//          Order o2 = new Order("R2", "19/11/2024", "26/11/2024", "000-003");
//          Order o3 = new Order("R4", "11/11/2024", "24/11/2024", "000-001");
//          Order o4 = new Order("R5", "12/11/2024", "29/11/2024", "000-003");
//          admin.addOrder(o1);
//          admin.addOrder(o2);
//          admin.addOrder(o3);
//          admin.addOrder(o4);
//          admin.orderList();
//          admin.bookList();
          
          //Test delete Order
//          admin.deleteOrder("O3");
//          admin.orderList();
//          admin.bookList();
          
          //Test so sanh khi da add, deleteOrder
//          admin.deleteOrder("O4");
//          admin.orderList();
//          admin.bookList();
          
          //Test getFine
//          admin.readerList();
    
//          ArrayList<Book> l = new ArrayList<>();
//          ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("BOOK.in"));
//          out.writeObject(l);
//          admin.bookList();

        //Reset file Reader
//        ArrayList<Reader> l = new ArrayList<>();
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("READER.in"));
//        out.writeObject(l);
//        admin.readerList();
        
        //Reset file Order
//        ArrayList<Order> l = new ArrayList<>();
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Order.in"));
//        out.writeObject(l);
//        admin.orderList();

        //Test ham search book bang title
        admin.bookList();
        System.out.println("Tim sach :");
        admin.searchBook("Qua den");

    }
    
}
