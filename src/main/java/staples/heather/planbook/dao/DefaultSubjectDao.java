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
import staples.heather.planbook.entity.Subject;

@Component
@Slf4j
public class DefaultSubjectDao implements SubjectDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  
  @Override
  public List<Subject> listAllSubjects() {
   
    String sqlFetch = "SELECT * FROM subject";
        
    Map<String,Object> params = new HashMap<>();
        
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

      @Override
      public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Subject.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .build();
      }});
    }  
  @Override
  public List<Subject> fetchSubject(String name) {
    
    String sqlFetch = "SELECT * FROM subject WHERE name = :name";
        
    Map<String,Object> params = new HashMap<>();
    params.put("name", name);
    
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

      @Override
      public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Subject.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .build();
      }});
    }
@Override
  public void deleteSubject(String name) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM subject "
        + "WHERE name = :name;";
    // @formatter:on    
       
    Map<String, Object> params = new HashMap<>();
    
    params.put("name", name);    
    jdbcTemplate.update(sql,  params);
  }
  @Override
  public void createSubject(String name) {
   
   String sqlCreate = "INSERT INTO subject (name) VALUES (name = :name)";
       
   Map<String,Object> params = new HashMap<>();
   params.put("name", name);
   
   jdbcTemplate.update(sqlCreate,  params);
  //we don't have access to id because auto-incrementing
  //get get id by retrieving this from database
//     return Subject.builder()
//         .name(name)
//         .build(); 
  }
  
  @Override
   public void updateSubject(String oldName, String newName) {
     
     String sqlUpdate = "UPDATE subject SET name = :newName WHERE name = :oldName";
 
     
  //HOW TO DEAL WITH THESE PARAMS
     
     Map<String,Object> params = new HashMap<>();
     params.put("oldName", oldName);
     params.put("newName", newName);
     
     jdbcTemplate.update(sqlUpdate,  params);
     //we don't have access to id because auto-incrementing
     //get get id by retrieving this from database
//        return Subject.builder()
//            .name(newName)
//            .build();
     }

 
}
