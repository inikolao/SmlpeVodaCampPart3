package iniko.Voda.Services;

import iniko.Voda.DTO.FileType;
import iniko.Voda.Repos.FileTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileTypeService {

    @Autowired
    private FileTypeRepo fileTypeRepo;

    public void CreateFileType(FileType fileType)
    {
        fileTypeRepo.save(fileType);
    }

    public List<FileType> GetNumFileTypes(int num)
    {
        List<FileType> fileTypes=new ArrayList<>();
        List<FileType> typesReturned=null;
        fileTypeRepo.findAll().forEach(fileTypes::add);
        for (int i = 0; i < num; i++) {
            typesReturned.add(fileTypes.get(i));
        }
        return typesReturned;
    }
    public List<FileType> GetAllFileTypes(int num)
    {
        List<FileType> fileTypes=new ArrayList<>();
        fileTypeRepo.findAll().forEach(fileTypes::add);
        return fileTypes;
    }
    public FileType GetFileTypeByID(int id)
    {
        return fileTypeRepo.findById(id).orElseThrow(()-> new  EntityNotFoundException("File Type with "+id+" not found"));
    }
}
