package staples.heather.planbook.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Day {
  private int dayId;
  private String dayOfTheWeek;
  private List<Lesson> lessons; 
  
  @JsonIgnore
  public int getId() {
    return dayId;
  }

}
