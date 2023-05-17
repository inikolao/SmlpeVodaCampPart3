package iniko.Voda.Services.DB;

import iniko.Voda.DTO.User;
import iniko.Voda.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepo userRepo;

    public void CreateUser(User user)
    {
        userRepo.save(user);
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public Page<User> findByUsernamePages(String username,int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        //List<User> users=userRepo.findUserByUsernameContainingIgnoreCase(username);
        //user
        return userRepo.findUserByUsernameContainingIgnoreCase(username,pageable);
    }
    public User save(User user) {
        return userRepo.save(user);
    }

    public User findAdmin() {
        return userRepo.findByIsAdminTrue();
    }

    public List<User> findAll()
    {
        return userRepo.findAll();
    }

    public Page<User> findAllP(int pageNumber, int pageSize)
    {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return userRepo.findAll(pageable);

    }
    @Transactional
    public User getUserByID(int id){ return userRepo.findByUserID(id);}

    @Transactional
    public void deleteUser(User user)
    {
        userRepo.delete(user);
    }

}
