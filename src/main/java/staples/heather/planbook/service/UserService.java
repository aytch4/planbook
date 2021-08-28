package staples.heather.planbook.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import staples.heather.planbook.entity.User;

public interface UserService {

  List<User> fetchUser(String name);
  
  List<User> listAllUsers();
 
  void deleteUser(String name);

  void createUser(String name);
  
  void updateUser(String newName, String oldName);

}
