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
public class Lesson {
  private int id;
  private String name;
  private String objective;
  private String content;
  private int unitId;
 
  @JsonIgnore
  public int getId() {
    return id;
  }
}


