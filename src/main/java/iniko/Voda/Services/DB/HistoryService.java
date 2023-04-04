package iniko.Voda.Services.DB;

import iniko.Voda.DTO.UserHistory;
import iniko.Voda.Repos.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepo historyRepo;

    private void CreateHistroy(UserHistory history)
    {
        historyRepo.save(history);
    }

}
