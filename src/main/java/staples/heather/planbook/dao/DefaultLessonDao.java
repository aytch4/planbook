package staples.heather.planbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.entity.Lesson;

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
          .lessonId(rs.getInt("lessonId"))
          .lessonName(rs.getString("lessonName"))
          .objective(rs.getString("objective"))
          .content(rs.getString("content"))
          .unitId(rs.getInt("unitId"))
          .build();
    }});
    
    }

  @Override
  public List<Lesson> fetchLessonById(int lessonId) {
    
    String sqlFetch = "SELECT * FROM lesson WHERE lessonId = :lessonId";
        
    Map<String,Object> params = new HashMap<>();
    params.put("lessonId", lessonId);
    
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

      @Override
      public Lesson mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Lesson.builder()
            .lessonId(rs.getInt("lessonId"))
            .lessonName(rs.getString("lessonName"))
            .objective(rs.getString("objective"))
            .content(rs.getString("content"))
            .unitId(rs.getInt("unitId"))
            .build();
      }});
    }

  @Override
  public List<Lesson> fetchLessonsByUnit(int unitId) {
    
    String sqlFetch = "SELECT * FROM lesson WHERE unitId = :unitId";
        
    Map<String,Object> params = new HashMap<>();
    params.put("unitId", unitId);
    
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

      @Override
      public Lesson mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Lesson.builder()
            .lessonId(rs.getInt("lessonId"))
            .lessonName(rs.getString("lessonName"))
            .objective(rs.getString("objective"))
            .content(rs.getString("content"))
            .unitId(rs.getInt("unitId"))
            .build();
      }});
    }
  
  
public int deleteLesson(int lessonId) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM lesson "
        + "WHERE lessonId = :lessonId;";
    // @formatter:on    
       
    Map<String, Object> params = new HashMap<>();
    
    params.put("lessonId", lessonId);    
    if (jdbcTemplate.update(sql,  params) == 0) {
      throw new NoSuchElementException();
    };
    return jdbcTemplate.update(sql, params);
   }
  

  
  public void createLesson(String lessonName, String objective, String content, int unitId) {
   
   String sqlCreate = "INSERT INTO lesson (lessonName, objective, content, unitId) VALUES ( :lessonName, :objective, :content,  :unitId)";
       
   Map<String,Object> params = new HashMap<>();
   params.put("lessonName", lessonName);
   params.put("objective", objective);
   params.put("content", content);
   params.put("unitId", unitId);
   
   jdbcTemplate.update(sqlCreate,  params);
  }

  
  public int updateLesson(int lessonId, String newContent) {
     
    String sqlUpdate = "UPDATE lesson SET content = :newContent WHERE lessonId = :lessonId";
     
     Map<String,Object> params = new HashMap<>();
     params.put("lessonId", lessonId);
     params.put("newContent", newContent);
     
     if (jdbcTemplate.update(sqlUpdate,  params) == 0) {
       throw new NoSuchElementException();
     };
     return jdbcTemplate.update(sqlUpdate, params);
    }
  }


 
