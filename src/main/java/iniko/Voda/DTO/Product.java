package iniko.Voda.DTO;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Products")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Prod_ID;
    private String Name;
    private String Description;
    @OneToMany
    @Cascade(CascadeType.DELETE)
    private List<File> FilesRelated;
    private long Price;
    @ManyToOne
    @Cascade(CascadeType.DELETE)
    private ProductCategory Category;
    private int Rating;
    private Date DateAdded;
    @ManyToOne
    @Cascade(CascadeType.DELETE)
    private ProductType Type;

    public Product() {
    }

    public Product(int prod_ID, String name, String description, List<File> filesRelated, long price, ProductCategory category, int rating, Date dateAdded, ProductType type) {
        Prod_ID = prod_ID;
        Name = name;
        Description = description;
        FilesRelated = filesRelated;
        Price = price;
        Category = category;
        Rating = rating;
        DateAdded = dateAdded;
        Type = type;
    }

    public int getProd_ID() {
        return Prod_ID;
    }

    public void setProd_ID(int prod_ID) {
        Prod_ID = prod_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<File> getFilesRelated() {
        return FilesRelated;
    }

    public void setFilesRelated(List<File> filesRelated) {
        FilesRelated = filesRelated;
    }

    public long getPrice() {
        return Price;
    }

    public void setPrice(long price) {
        Price = price;
    }

    public ProductCategory getCategory() {
        return Category;
    }

    public void setCategory(ProductCategory category) {
        Category = category;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public Date getDateAdded() {
        return DateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        DateAdded = dateAdded;
    }

    public ProductType getType() {
        return Type;
    }

    public void setType(ProductType type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Prod_ID=" + Prod_ID +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", FilesRelated=" + FilesRelated +
                ", Price=" + Price +
                ", Category=" + Category +
                ", Rating=" + Rating +
                ", DateAdded=" + DateAdded +
                ", Type=" + Type +
                '}';
    }
}
