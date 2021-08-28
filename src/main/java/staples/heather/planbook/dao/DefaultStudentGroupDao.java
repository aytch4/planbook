package staples.heather.planbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.entity.StudentGroup;

@Component
@Slf4j
public class DefaultStudentGroupDao implements StudentGroupDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<StudentGroup> listAllStudentGroups() {
   
    String sqlFetch = "SELECT * FROM student_group";
        
    Map<String,Object> params = new HashMap<>();
        
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

      @Override
      public StudentGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
        return StudentGroup.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .userId(rs.getInt("user_id"))
            .build();
      }});
    } 
  
  @Override
  public List<StudentGroup> fetchStudentGroup(String name) {
    
    String sqlFetch = "SELECT * FROM student_group WHERE name = :name";
        
    Map<String,Object> params = new HashMap<>();
    params.put("name", name);
    
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

      @Override
      public StudentGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
        return StudentGroup.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .userId(rs.getInt("user_id"))
            .build();
      }});
    }

@Override
  public void deleteStudentGroup(String name) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM studentGroup "
        + "WHERE name = :name;";
    // @formatter:on    
       
    Map<String, Object> params = new HashMap<>();
    
    params.put("name", name);    
    jdbcTemplate.update(sql,  params);
  }
  
  @Override
  public void createStudentGroup(String name, int user_id) {
   
   String sqlCreate = "INSERT INTO student_group (name, user_id) VALUES (name = :name, user_id = :user_id)";
       
   Map<String,Object> params = new HashMap<>();
   params.put("name", name);
   
   jdbcTemplate.update(sqlCreate,  params);
  //we don't have access to id because auto-incrementing
  //get get id by retrieving this from database
//     return StudentGroup.builder()
//         .name(name)
//         .build(); 
  }
  
  @Override
   public void updateStudentGroup(String oldName, String newName) {
     
     String sqlUpdate = "UPDATE user SET name = :newName WHERE name = :oldName";
 
     
  //HOW TO DEAL WITH THESE PARAMS
     
     Map<String,Object> params = new HashMap<>();
     params.put("oldName", oldName);
     params.put("newName", newName);
     
     jdbcTemplate.update(sqlUpdate,  params);
     //we don't have access to id because auto-incrementing
     //get get id by retrieving this from database
//        return StudentGroup.builder()
//            .name(newName)
//            .build();
     }

}
