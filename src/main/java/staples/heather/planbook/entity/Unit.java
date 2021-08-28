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
public class Unit {
  private int id;
  private String name;
  private int subjectId;
  
  @JsonIgnore
  public int getId() {
    return id;
  }
}
