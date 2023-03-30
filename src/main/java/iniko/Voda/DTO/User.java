package iniko.Voda.DTO;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int UserID;
    private String Username;
    private String Password;
    private String Name;
    private String Surname;
    private String Mobile;
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Order> Orders;
    private Boolean IsAdmin;
    private Boolean IsActive;
    private Date LastLogIn;
    private Date DateCreated;

    public User() {
    }

    public User(int userID, String username, String password, String name, String surname, String mobile, List<Order> orders, Boolean isAdmin, Boolean isActive, Date lastLogIn, Date dateCreated) {
        UserID = userID;
        Username = username;
        Password = password;
        Name = name;
        Surname = surname;
        Mobile = mobile;
        Orders = orders;
        IsAdmin = isAdmin;
        IsActive = isActive;
        LastLogIn = lastLogIn;
        DateCreated = dateCreated;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public List<Order> getOrders() {
        return Orders;
    }

    public void setOrders(List<Order> orders) {
        Orders = orders;
    }

    public Boolean getAdmin() {
        return IsAdmin;
    }

    public void setAdmin(Boolean admin) {
        IsAdmin = admin;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        IsActive = active;
    }

    public Date getLastLogIn() {
        return LastLogIn;
    }

    public void setLastLogIn(Date lastLogIn) {
        LastLogIn = lastLogIn;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        DateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Orders=" + Orders +
                ", IsAdmin=" + IsAdmin +
                ", IsActive=" + IsActive +
                ", LastLogIn=" + LastLogIn +
                ", DateCreated=" + DateCreated +
                '}';
    }
}
