package iniko.Voda.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="WhshList")
@Getter
@Setter
@NoArgsConstructor
public class WishList {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Product> productList;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private User userOwner;

    private Date DateCreated;

    public WishList(User userOwner) {
        this.userOwner = userOwner;
        this.productList=new ArrayList<>();
        setDateCreatedN();
    }

    public void setDateCreatedN() {
        Date dateOne = new Date();
        Instant inst = Instant.now();
        DateCreated = dateOne.from(inst);
    }
}
