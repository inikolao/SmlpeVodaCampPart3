package iniko.Voda.Repos;

import iniko.Voda.DTO.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<File,Integer> {
}
