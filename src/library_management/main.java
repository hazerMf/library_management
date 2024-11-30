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
        
        
    }
    
}
