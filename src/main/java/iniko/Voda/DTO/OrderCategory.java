package iniko.Voda.DTO;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OrderCategories")
public class OrderCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int orderCTID;
    private String Name;
    private Date DateCreated;

    public OrderCategory() {
    }

    public OrderCategory(int orderCTID, String name, Date dateCreated) {
        this.orderCTID = orderCTID;
        Name = name;
        DateCreated = dateCreated;
    }

    public int getOrderCTID() {
        return orderCTID;
    }

    public void setOrderCTID(int orderCTID) {
        this.orderCTID = orderCTID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        DateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "OrderCategory{" +
                "OrderCT_ID=" + orderCTID +
                ", Name='" + Name + '\'' +
                ", DateCreated=" + DateCreated +
                '}';
    }
}
