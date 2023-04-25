package iniko.Voda.Repos;

import iniko.Voda.DTO.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<UserHistory,Integer> {
}
