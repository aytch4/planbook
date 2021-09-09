package staples.heather.planbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.entity.Day;
import staples.heather.planbook.entity.Lesson;

@Component
@Slf4j
public class DefaultDaysLessonsDao implements DaysLessonsDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  //displays lessons for the week - READ
  @Override
  public List<Day> listWeeksLessons() {
    
    String sqlFetch = "SELECT * from day inner join daysLessons on day.dayId = daysLessons.dayId "
        + "INNER JOIN lesson on lesson.lessonId = daysLessons.lessonId group by day.dayId order by day.dayId";
    
    Map<String,Object> params = new HashMap<>();
    
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

    @Override
    public Day mapRow(ResultSet rs, int rowNum) throws SQLException {
      return Day.builder()
          .dayId(rs.getInt("dayId"))
          .dayOfTheWeek(rs.getString("dayOfTheWeek"))
          .lessons(fetchLessonsByDay(rs.getString("dayOfTheWeek")))
          .build();
    }});     
   } 
  
  //displays lessons for the day - READ
  @Override
  public List<Lesson> fetchLessonsByDay(String dayOfTheWeek) {
    String sqlFetch = "SELECT * FROM lesson INNER JOIN daysLessons on lesson.lessonId = daysLessons.lessonId "
        + "INNER JOIN day on day.dayId = daysLessons.dayId WHERE dayOfTheWeek = :dayOfTheWeek";
        
    Map<String,Object> params = new HashMap<>();
    params.put("dayOfTheWeek", dayOfTheWeek);
    
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

  //disassociates lessons from days of the week - DELETE
  @Override
  public void clearWeeksLessons() {
    String sql = "DELETE FROM daysLessons";
       
    Map<String, Object> params = new HashMap<>();    
    jdbcTemplate.update(sql, params);
  }
  
//unassigns lesson from day - DELETE
  @Override
  public int deleteLessonFromDay(int lessonId) {
    String sql = "DELETE FROM daysLessons WHERE lessonId = :lessonId";  
       
    Map<String, Object> params = new HashMap<>();
    params.put("lessonId", lessonId); 
    if (jdbcTemplate.update(sql,  params) == 0) {
      throw new NoSuchElementException();
    };
    return jdbcTemplate.update(sql, params);
  }
  
  //assigns lessons to day of the week for planbook - CREATE
  @Override
  public void assignLessonsToDay(int dayId, int lessonId) {
   
   String sqlCreate = "INSERT INTO daysLessons (dayId, lessonId) VALUES (:dayId,  :lessonId)";
       
   Map<String,Object> params = new HashMap<>();
   params.put("dayId", dayId);
   params.put("lessonId", lessonId);
   
   jdbcTemplate.update(sqlCreate,  params);
  }
    
  //change lesson day - UPDATE
  @Override
   public int updateDayOfLesson(int lessonId, int newDay) {
     
     String sqlUpdate = "UPDATE daysLessons SET dayId = :newDay WHERE lessonId = :lessonId";
     
     Map<String,Object> params = new HashMap<>();
     params.put("newDay", newDay);
     params.put("lessonId", lessonId);
    
     if (jdbcTemplate.update(sqlUpdate,  params) == 0) {
       throw new NoSuchElementException();
     };
     return jdbcTemplate.update(sqlUpdate, params);
     }
  
  
}
