package iniko.Voda.Services;

import iniko.Voda.DTO.User;
import iniko.Voda.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void CreateUser(User user)
    {
        userRepo.save(user);
    }
}
