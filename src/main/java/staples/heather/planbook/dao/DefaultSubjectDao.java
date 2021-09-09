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
            .subjectId(rs.getInt("subjectId"))
            .subjectName(rs.getString("subjectName"))
            .build();
      }});
    }  

}
