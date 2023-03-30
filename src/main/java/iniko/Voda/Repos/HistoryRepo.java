package iniko.Voda.Repos;

import iniko.Voda.DTO.UserHistory;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepo extends CrudRepository<UserHistory,Integer> {
}
