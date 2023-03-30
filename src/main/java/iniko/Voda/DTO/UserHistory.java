package iniko.Voda.DTO;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="UserHistory")
public class UserHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int UserHID;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    private User User;
    private String Action;
    private Date ActionDate;

    public UserHistory() {
    }

    public UserHistory(int userHID, iniko.Voda.DTO.User user, String action, Date actionDate) {
        UserHID = userHID;
        User = user;
        Action = action;
        ActionDate = actionDate;
    }

    public int getUserHID() {
        return UserHID;
    }

    public void setUserHID(int userHID) {
        UserHID = userHID;
    }

    public iniko.Voda.DTO.User getUser() {
        return User;
    }

    public void setUser(iniko.Voda.DTO.User user) {
        User = user;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public Date getActionDate() {
        return ActionDate;
    }

    public void setActionDate(Date actionDate) {
        ActionDate = actionDate;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "UserHID=" + UserHID +
                ", User=" + User +
                ", Action='" + Action + '\'' +
                ", ActionDate=" + ActionDate +
                '}';
    }
}
