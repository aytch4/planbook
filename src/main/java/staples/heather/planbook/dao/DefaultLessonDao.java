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
import staples.heather.planbook.entity.Lesson;
import staples.heather.planbook.entity.StudentGroup;
import staples.heather.planbook.entity.Subject;
import staples.heather.planbook.entity.Unit;
import staples.heather.planbook.entity.User;

@Component
@Slf4j
public class DefaultLessonDao implements LessonDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  public List<Lesson> listAllLessons() {
   
    String sqlFetch = "SELECT * FROM lesson";
        
    Map<String,Object> params = new HashMap<>();
    
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

    @Override
    public Lesson mapRow(ResultSet rs, int rowNum) throws SQLException {
      return Lesson.builder()
          .id(rs.getInt("id"))
          .name(rs.getString("name"))
          .objective(rs.getString("objective"))
          .content(rs.getString("content"))
          .unitId(rs.getInt("unit_Id"))
          .build();
    }});
    
    }

  @Override
  public List<Lesson> fetchLesson(int id) {
    
    String sqlFetch = "SELECT * FROM lesson WHERE id = :id";
        
    Map<String,Object> params = new HashMap<>();
    params.put("id", id);
    
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

      @Override
      public Lesson mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Lesson.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .objective(rs.getString("objective"))
            .content(rs.getString("content"))
            .unitId(rs.getInt("unit_Id"))
            .build();
      }});
    }

public void deleteLesson(int id) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM lesson "
        + "WHERE id = :id;";
    // @formatter:on    
       
    Map<String, Object> params = new HashMap<>();
    
    params.put("id", id);    
    jdbcTemplate.update(sql,  params);
  }

  public void createLesson(String name, String objective, String content, int unit_id) {
   
   String sqlCreate = "INSERT INTO unit (name, objective, content, unit_id) VALUES (name = :name, objective = :objective, content = :content, unit_id = :unit_id)";
       
   Map<String,Object> params = new HashMap<>();
   params.put("name", name);
   params.put("objective", objective);
   params.put("content", content);
   params.put("unit_id", unit_id);
   
   jdbcTemplate.update(sqlCreate,  params);
  //we don't have access to id because auto-incrementing
  //get get id by retrieving this from database
//   return Lesson.builder()
//       .name(name)
//       .objective(objective)
//       .content(content)
//       .unitId(unit_id)
//       .build();
  }

  
  public void updateLesson(int id, String newName, String newObjective, String newContent) {
     
    String sqlUpdate = "UPDATE lesson SET name = :newName, objective = :newObjective, content = :newContent WHERE id = :id";
 
     
  //HOW TO DEAL WITH THESE PARAMS
     
     Map<String,Object> params = new HashMap<>();
     params.put("id", id);
     params.put("newName", newName);
     params.put("newObjective", newObjective);
     params.put("newContent", newContent);
     
     jdbcTemplate.update(sqlUpdate,  params);
     //we don't have access to id because auto-incrementing
     //get get id by retrieving this from database
//     return Lesson.builder()
//         .name(newName)
//         .objective(newObjective)
//         .content(newContent)
//         .build();
     }

  
 
}