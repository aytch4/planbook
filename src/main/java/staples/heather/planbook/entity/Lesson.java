package staples.heather.planbook.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
  private int lessonId;
  
  @Column(value="lessonName")
  private String lessonName;
  private String objective;
  private String content;
  private int unitId;
 
  @JsonIgnore
  public int getId() {
    return lessonId;
  }
}

