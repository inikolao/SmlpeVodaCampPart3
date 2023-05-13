package iniko.Voda.DTO;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int UserID;

    @Column(name="Username")
    private String username;
    private String Password;
    private String Name;
    private String Surname;
    private String Mobile;
    @OneToMany
    @Cascade(CascadeType.DELETE)
    private List<Order> Orders;

    @Column(name="IsAdmin")
    private Boolean isAdmin;
    private Boolean IsActive;
    private Date LastLogIn;
    private Date DateCreated;

    public User() {
    }

    public User(int userID, String username, String password, String name, String surname, String mobile, List<Order> orders, Boolean isAdmin, Boolean isActive, Date lastLogIn, Date dateCreated) {
        UserID = userID;
        this.username = username;
        Password = password;
        Name = name;
        Surname = surname;
        Mobile = mobile;
        Orders = orders;
        this.isAdmin = isAdmin;
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
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
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
                ", Username='" + username + '\'' +
                ", Password='" + Password + '\'' +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Orders=" + Orders +
                ", IsAdmin=" + isAdmin +
                ", IsActive=" + IsActive +
                ", LastLogIn=" + LastLogIn +
                ", DateCreated=" + DateCreated +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (isAdmin) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return IsActive;
    }
}
