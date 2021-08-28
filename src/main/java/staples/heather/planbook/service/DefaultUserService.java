package staples.heather.planbook.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.dao.UserDao;
import staples.heather.planbook.entity.User;

@Service
@Slf4j
public class DefaultUserService implements UserService{


  @Autowired
  private UserDao userDao;

  @Override
  public List<User> fetchUser(String name) {
    
    return userDao.fetchUser(name);
  }

  @Override
  public List<User> listAllUsers() {
    List<User> users = userDao.listAllUsers();
    return users;
  }

  @Override
  public void createUser(String name) {
    userDao.createUser(name);
  }

  @Override
  public void updateUser(String newName, String oldName) {
    userDao.updateUser(newName, oldName);
  }
  
  @Override
  public void deleteUser(String name) {
     userDao.deleteUser(name);
   }


  }

  