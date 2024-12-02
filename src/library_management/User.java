package library_management;

import java.io.Serializable;

public class User implements IUser, Serializable {
    private String name; // Ten User
    private String phone; // So dien thoai User
    private String email; // Dia chi email User

    
    // Constructor
    public User(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Ham encap dat ten User
    public void setName(String name) {
        this.name = name;
    }
    
    // Ham encap tra ve ten User, duoc Override tu Interface IUser
    @Override
    public String getName() {
        return name;
    }
    
    // Ham encap tra ve so dien thoai User, duoc Override tu Interface IUser
    @Override
    public String getPhone() {
        return phone;
    }
    
    // Ham encap dat so dien thoai User
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    // Ham encap tra ve dia chi email User, duoc Override tu Interface IUser
    @Override
    public String getEmail() {
        return email;
    }
    
    // Ham encap dat dia chi email User
    public void setEmail(String email) {
        this.email = email;
    }

}
