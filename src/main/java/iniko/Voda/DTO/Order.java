package iniko.Voda.DTO;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int orderID;
    @OneToOne
    @Cascade(CascadeType.DELETE)
    private User UserCreated;
    @OneToOne
    @Cascade(CascadeType.DELETE)
    private OrderCategory category;
    @OneToMany
    @Cascade(CascadeType.DELETE)
    private List<Product> Products;
    private long total;
    private int NumProducts;
    private Date dateCreated;

    public Order() {
    }

    public Order(int orderID, User userCreated, OrderCategory category, List<Product> products, long total, int numProducts, Date dateCreated) {
        this.orderID = orderID;
        UserCreated = userCreated;
        this.category = category;
        Products = products;
        this.total = total;
        NumProducts =Products.size();
        this.dateCreated = dateCreated;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public User getUserCreated() {
        return UserCreated;
    }

    public void setUserCreated(User userCreated) {
        UserCreated = userCreated;
    }

    public OrderCategory getCategory() {
        return category;
    }

    public void setCategory(OrderCategory category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getNumProducts() {
        return NumProducts;
    }

    public void setNumProducts(int numProducts) {
        NumProducts = numProducts;
    }

    public void setNumProducts() {
        NumProducts = Products.size();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderID=" + orderID +
                ", UserCreated=" + UserCreated +
                ", Category=" + category +
                ", Products=" + Products +
                ", Total=" + total +
                ", NumProducts=" + NumProducts +
                ", DateCreated=" + dateCreated +
                '}';
    }
}
