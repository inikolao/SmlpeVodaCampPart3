package iniko.Voda.DTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Product_Categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ProdC_ID;
    private String name;
    private Date Date_created;

    public ProductCategory() {
    }

    public ProductCategory(int prodC_ID, String name, Date date_created) {
        ProdC_ID = prodC_ID;
        this.name = name;
        Date_created = date_created;
    }

    public int getProdC_ID() {
        return ProdC_ID;
    }

    public void setProdC_ID(int prodC_ID) {
        ProdC_ID = prodC_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_created() {
        return Date_created;
    }

    public void setDate_created(Date date_created) {
        Date_created = date_created;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "ProdC_ID=" + ProdC_ID +
                ", Name='" + name + '\'' +
                ", Date_created=" + Date_created +
                '}';
    }
}
