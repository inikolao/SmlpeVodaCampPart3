package iniko.Voda.DTO;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OrderCategories")
public class OrderCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int OrderCT_ID;
    private String Name;
    private Date DateCreated;

    public OrderCategory() {
    }

    public OrderCategory(int orderCT_ID, String name, Date dateCreated) {
        OrderCT_ID = orderCT_ID;
        Name = name;
        DateCreated = dateCreated;
    }

    public int getOrderCT_ID() {
        return OrderCT_ID;
    }

    public void setOrderCT_ID(int orderCT_ID) {
        OrderCT_ID = orderCT_ID;
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
                "OrderCT_ID=" + OrderCT_ID +
                ", Name='" + Name + '\'' +
                ", DateCreated=" + DateCreated +
                '}';
    }
}
