package library_management;

import library_management.gui.LoginFrame;
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
        
        LoginFrame lgf = new LoginFrame();
        lgf.setTitle("Log in");
        lgf.setVisible(true);
        lgf.setSize(854,480);
        lgf.setResizable(false);
        lgf.setLocationRelativeTo(null);

//        Manager m = new Manager("", "", "");
//        System.out.println("Danh sach sach: ");
//        m.bookList();
//        System.out.println("Danh sach ng doc: ");
//        m.readerList();
//        System.out.println("Danh sach don: ");
//        m.orderList();
//        System.out.println("Tien phat R01 cho don Oo1: " + m.getReaderById("R01").getFineOrder("O01"));
//        System.out.println("Tien phat R01 cho don O02: " + m.getReaderById("R01").getFineOrder("O02"));
//        System.out.println("Tien phat tong R01: " + m.getReaderById("R01").getFine());
//        System.out.println("Tien phat R03 cho don O04: " + m.getReaderById("R03").getFineOrder("O04"));
//        System.out.println("Tine phat tong R03: " + m.getReaderById("R03").getFine());

    }
    
}
