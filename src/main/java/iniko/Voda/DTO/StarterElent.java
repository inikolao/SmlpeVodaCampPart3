package iniko.Voda.DTO;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class StarterElent implements Serializable {

    @Id
    private int ID;
    private String kexample;

    public StarterElent() {
    }

    public StarterElent(String example) {
        this.kexample = example;
    }

    public StarterElent(int ID, String example) {
        this.ID = ID;
        this.kexample = example;
    }

    public String getKexample() {
        return kexample;
    }

    public void setKexample(String kexample) {
        this.kexample = kexample;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "StarterElent{" +
                "ID=" + ID +
                ", kexample='" + kexample + '\'' +
                '}';
    }
}
