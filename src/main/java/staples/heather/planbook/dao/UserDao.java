package staples.heather.planbook.dao;

import java.util.List;
import org.springframework.http.ResponseEntity;
import staples.heather.planbook.entity.User;

public interface UserDao {

  List<User> fetchUser(String name);
  
  List<User> listAllUsers();
  
  void createUser(String name);
  
  void updateUser(String newName, String oldName);

  void deleteUser(String name);
}
