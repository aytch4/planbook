package staples.heather.planbook.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.entity.User;
import staples.heather.planbook.service.UserService;

@RestController
@Slf4j
public class BasicUserController implements UserController{

  @Autowired
  private UserService userService;
  
  @Override
  public List<User> fetchUser(String name) {
    log.debug("name={}", name);
        
        return userService.fetchUser(name);
  }

  @Override
  public List<User> listAllUsers() {
    return userService.listAllUsers();
  }

  @Override
  public void createUser(String name) {
    userService.createUser(name);
   }

  @Override
  public void updateUser(String newName, String oldName) {
    userService.updateUser(newName, oldName);
    
  }

  @Override
  public void deleteUser(String name) {
    userService.deleteUser(name);
  }

  


}