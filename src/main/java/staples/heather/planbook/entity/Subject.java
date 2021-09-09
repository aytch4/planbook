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
public class Subject {
  private int subjectId;
  private String subjectName;
  
  @JsonIgnore
  public int getId() {
    return subjectId;
  }
}
