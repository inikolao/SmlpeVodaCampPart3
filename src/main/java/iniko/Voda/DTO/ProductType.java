package iniko.Voda.DTO;

import javax.persistence.*;

@Entity
@Table(name="ProductTypes")
public class ProductType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int PrdTp_ID;
    private String Type;

    public ProductType() {
    }

    public ProductType(int prdTp_ID, String type) {
        PrdTp_ID = prdTp_ID;
        Type = type;
    }

    public int getPrdTp_ID() {
        return PrdTp_ID;
    }

    public void setPrdTp_ID(int prdTp_ID) {
        PrdTp_ID = prdTp_ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "PrdTp_ID=" + PrdTp_ID +
                ", Type='" + Type + '\'' +
                '}';
    }
}
