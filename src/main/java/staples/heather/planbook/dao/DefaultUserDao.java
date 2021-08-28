package staples.heather.planbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.entity.User;

@Component
@Slf4j
public class DefaultUserDao implements UserDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;  
  
  @Override
  public List<User> listAllUsers() {
   
    String sqlFetch = "SELECT * FROM user";
        
    Map<String,Object> params = new HashMap<>();
        
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

      @Override
      public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .build();
      }});
    }  
 
  
 //why doesn't it display id? 
 
  @Override
  public List<User> fetchUser(String name) {
    
    String sqlFetch = "SELECT * FROM user WHERE name = :name";
        
    Map<String,Object> params = new HashMap<>();
    params.put("name", name);
    
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

      @Override
      public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .build();
      }});
    }
@Override
  public void deleteUser(String name) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM user "
        + "WHERE name = :name;";
    // @formatter:on    
       
    Map<String, Object> params = new HashMap<>();
    
    params.put("name", name);    
    jdbcTemplate.update(sql,  params);
  }

  @Override
  public void createUser(String name) {
      String sqlCreate =  "INSERT INTO user (name) VALUES (:name)";
      
      Map<String, Object> params = new HashMap<>();
      params.put("name", name);  
      
      jdbcTemplate.update(sqlCreate,  params);
      
  }
  
  //HOW?!
  @Override
   public void updateUser(String newName, String oldName) {
     
     String sqlUpdate = "UPDATE user SET name = :newName WHERE name = :oldName";
 
     
  //HOW TO DEAL WITH THESE PARAMS
     
     Map<String,Object> params = new HashMap<>();
     params.put("newName", newName);
     params.put("oldName", oldName);
     
     jdbcTemplate.update(sqlUpdate,  params);
     //we don't have access to id because auto-incrementing
     //get get id by retrieving this from database
//        return User.builder()
//            .name(newName)
//            .build();
     }
 
}


