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
    private int OrderID;
    @OneToOne
    @Cascade(CascadeType.DELETE)
    private User UserCreated;
    @OneToOne
    @Cascade(CascadeType.DELETE)
    private OrderCategory Category;
    @OneToMany
    @Cascade(CascadeType.DELETE)
    private List<Product> Products;
    private long Total;
    private int NumProducts;
    private Date DateCreated;

    public Order() {
    }

    public Order(int orderID, User userCreated, OrderCategory category, List<Product> products, long total, int numProducts, Date dateCreated) {
        OrderID = orderID;
        UserCreated = userCreated;
        Category = category;
        Products = products;
        Total = total;
        NumProducts =Products.size();
        DateCreated = dateCreated;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public User getUserCreated() {
        return UserCreated;
    }

    public void setUserCreated(User userCreated) {
        UserCreated = userCreated;
    }

    public OrderCategory getCategory() {
        return Category;
    }

    public void setCategory(OrderCategory category) {
        Category = category;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    public long getTotal() {
        return Total;
    }

    public void setTotal(long total) {
        Total = total;
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
        return DateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        DateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderID=" + OrderID +
                ", UserCreated=" + UserCreated +
                ", Category=" + Category +
                ", Products=" + Products +
                ", Total=" + Total +
                ", NumProducts=" + NumProducts +
                ", DateCreated=" + DateCreated +
                '}';
    }
}
