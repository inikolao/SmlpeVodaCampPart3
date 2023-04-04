package iniko.Voda.Services.DB;

import iniko.Voda.DTO.File;
import iniko.Voda.Repos.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileRepo fileRepo;

    public void CreateFile(File file)
    {
        fileRepo.save(file);
    }
    public List<File> GetNumFiles(int num)
    {
        List<File> files=new ArrayList<>();
        List<File> filesReturned=new ArrayList<>();
        fileRepo.findAll().forEach(files::add);
        for (int i = 0; i < num; i++) {
            filesReturned.add(files.get(i));
        }
        return filesReturned;

    }
    public List<File> GetAllFiles()
    {
        List<File> files=new ArrayList<>();
        fileRepo.findAll().forEach(files::add);
        return files;
    }
    public File GetFileByID(int id)
    {
        return fileRepo.findById(id).orElseThrow(()->new EntityNotFoundException("File with "+id+" not found"));

    }
}
