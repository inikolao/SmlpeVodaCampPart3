package iniko.Voda.DTO;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ShoppingCard")
public class ShoppingCard {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int SpID;
    @OneToMany
    @Cascade(CascadeType.DELETE)
    private List<Product> products;
    @OneToOne
    @Cascade(CascadeType.DELETE)
    private User UserRelated;
    private long Total;
    private int NumProd;

    public ShoppingCard() {
    }

    public ShoppingCard(int spID, List<Product> products, User userRelated, long total, int numProd) {
        SpID = spID;
        this.products = products;
        UserRelated = userRelated;
        Total = total;
        NumProd = numProd;
    }

    public int getSpID() {
        return SpID;
    }

    public void setSpID(int spID) {
        SpID = spID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUserRelated() {
        return UserRelated;
    }

    public void setUserRelated(User userRelated) {
        UserRelated = userRelated;
    }

    public long getTotal() {
        return Total;
    }

    public void setTotal(long total) {
        Total = total;
    }

    public int getNumProd() {
        return NumProd;
    }

    public void setNumProd(int numProd) {
        NumProd = numProd;
    }

    @Override
    public String toString() {
        return "ShoppingCard{" +
                "SpID=" + SpID +
                ", products=" + products +
                ", UserRelated=" + UserRelated +
                ", Total=" + Total +
                ", NumProd=" + NumProd +
                '}';
    }
}
