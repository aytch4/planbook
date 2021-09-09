package staples.heather.planbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DaysLessons {
  private int daysLessonsId;
  private int dayId;
  private int lessonId;
  
//  @JsonIgnore
//  public int getId() {
//    return daysLessonsId;
//  }
}
