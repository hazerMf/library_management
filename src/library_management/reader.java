import java.util.ArrayList;

public class reader{
    private String name,email,phone,address;
    public ArrayList<String> borrowedBook = new ArrayList<String>();

    reader(String a,String b,String c,String d){
        this.name = a;
        this.email = b;
        this.phone = c;
        this.address = d;
    } 

    public void updateMail(String s){
        this.email=s;
    }

    public void updateAddress(String s){
        this.address=s;
    }

    public void updatePhone(String s){
        this.phone=s;
    }

    public void addOrder(String s){
        this.borrowedBook.add(s);
    }

    public void removeOrder(String s){
        this.borrowedBook.remove(s);
    }

    @Override
    public String toString(){
        return name+" "+email+" "+phone+" "+address;
    }
}