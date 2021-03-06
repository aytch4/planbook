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
public class Grade {
  private int gradeNumber;
  private String gradeName;
  
  
  @JsonIgnore
  public int getId() {
    return gradeNumber;
  }
}

