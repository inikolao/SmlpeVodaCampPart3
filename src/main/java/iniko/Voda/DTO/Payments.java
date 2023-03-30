package iniko.Voda.DTO;

import iniko.Voda.DTO.Enums.PaymentType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Payments")
public class Payments {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int PayId;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    private User User;
    private PaymentType Type;
    private Date DatePayment;
    private long Total;

    public Payments() {
    }

    public Payments(int payId, iniko.Voda.DTO.User user, PaymentType type, Date datePayment, long total) {
        PayId = payId;
        User = user;
        Type = type;
        DatePayment = datePayment;
        Total = total;
    }

    public int getPayId() {
        return PayId;
    }

    public void setPayId(int payId) {
        PayId = payId;
    }

    public iniko.Voda.DTO.User getUser() {
        return User;
    }

    public void setUser(iniko.Voda.DTO.User user) {
        User = user;
    }

    public PaymentType getType() {
        return Type;
    }

    public void setType(PaymentType type) {
        Type = type;
    }

    public Date getDatePayment() {
        return DatePayment;
    }

    public void setDatePayment(Date datePayment) {
        DatePayment = datePayment;
    }

    public long getTotal() {
        return Total;
    }

    public void setTotal(long total) {
        Total = total;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "PayId=" + PayId +
                ", User=" + User +
                ", Type=" + Type +
                ", DatePayment=" + DatePayment +
                ", Total=" + Total +
                '}';
    }
}
