package iniko.Voda.DTO;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Files")
public class File {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int File_ID;
    private String Name;
    private String FileLocation;
    private Date DateCreated;
    @OneToOne
    @Cascade(CascadeType.ALL)
    private FileType fileType;

    public File() {
    }

    public File(int file_ID, String name, String fileLocation, Date date_created, FileType fileType) {
        File_ID = file_ID;
        Name = name;
        FileLocation = fileLocation;
        DateCreated = date_created;
        this.fileType = fileType;
    }

    public int getFile_ID() {
        return File_ID;
    }

    public void setFile_ID(int file_ID) {
        File_ID = file_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFileLocation() {
        return FileLocation;
    }

    public void setFileLocation(String fileLocation) {
        FileLocation = fileLocation;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        DateCreated = dateCreated;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "File{" +
                "File_ID=" + File_ID +
                ", Name='" + Name + '\'' +
                ", FileLocation='" + FileLocation + '\'' +
                ", DateCreated=" + DateCreated +
                ", fileType=" + fileType +
                '}';
    }
}
