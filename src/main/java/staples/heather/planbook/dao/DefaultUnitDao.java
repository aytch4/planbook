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
import staples.heather.planbook.entity.Unit;

@Component
@Slf4j
public class DefaultUnitDao implements UnitDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Unit> listAllUnits() {
   
    String sqlFetch = "SELECT * FROM unit";
        
    Map<String,Object> params = new HashMap<>();
        
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

      @Override
      public Unit mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Unit.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .subjectId(rs.getInt("subject_id"))
            .build();
      }});
    }  
  
  @Override
  public List<Unit> fetchUnit(int id) {
    
    String sqlFetch = "SELECT * FROM unit WHERE id = :id";
        
    Map<String,Object> params = new HashMap<>();
    params.put("id", id);
    
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

      @Override
      public Unit mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Unit.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .subjectId(rs.getInt("subject_id"))
            .build();
      }});
    }

public void deleteUnit(int id) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM unit "
        + "WHERE id = :id;";
    // @formatter:on    
       
    Map<String, Object> params = new HashMap<>();
    
    params.put("id", id);    
    jdbcTemplate.update(sql,  params);
  }

  public void createUnit(String name, int subject_id) {
   
   String sqlCreate = "INSERT INTO unit (name, subject_id) VALUES (name = :name, subject_id = :subject_id)";
       
   Map<String,Object> params = new HashMap<>();
   params.put("name", name);
   params.put("subject_id", subject_id);
   
   jdbcTemplate.update(sqlCreate,  params);
  //we don't have access to id because auto-incrementing
  //get get id by retrieving this from database
//   return Unit.builder()
//       .name(name)
//       .subjectId(subject_id)
//       .build();
  }
  
  public void updateUnit(String oldName, String newName) {
     
    String sqlUpdate = "UPDATE unit SET name = :newName WHERE name = :oldName";
 
     
  //HOW TO DEAL WITH THESE PARAMS
     
     Map<String,Object> params = new HashMap<>();
     params.put("oldName", oldName);
     params.put("newName", newName);
     
     jdbcTemplate.update(sqlUpdate,  params);
     //we don't have access to id because auto-incrementing
     //get get id by retrieving this from database
//        return Unit.builder()
//            .name(newName)
//            .build();
     }
 
}
