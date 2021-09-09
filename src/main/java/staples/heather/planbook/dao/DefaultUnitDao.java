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
  public List<Unit> fetchUnitsBySubjectByGrade(int subjectId, int gradeNumber) {
    
    String sqlFetch = "SELECT * FROM unit WHERE subjectId = :subjectId AND gradeNumber = :gradeNumber";
        
    Map<String,Object> params = new HashMap<>();
    params.put("subjectId", subjectId);
    params.put("gradeNumber", gradeNumber);
    
    return jdbcTemplate.query(sqlFetch,  params, new RowMapper<>() {

      @Override
      public Unit mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Unit.builder()
            .unitId(rs.getInt("unitId"))
            .unitName(rs.getString("unitName"))
            .subjectId(rs.getInt("subjectId"))
            .gradeNumber(rs.getInt("gradeNumber"))
            .build();
      }});
    }
}
