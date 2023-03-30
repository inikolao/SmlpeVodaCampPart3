package iniko.Voda.DTO;

import javax.persistence.*;

@Entity
@Table(name = "FileTypes")
public class FileType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Type_ID;
    private String Type;

    public FileType() {
    }

    public FileType(int type_ID, String type) {
        Type_ID = type_ID;
        Type = type;
    }

    public int getType_ID() {
        return Type_ID;
    }

    public void setType_ID(int type_ID) {
        Type_ID = type_ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "FileType{" +
                "Type_ID=" + Type_ID +
                ", Type='" + Type + '\'' +
                '}';
    }
}
