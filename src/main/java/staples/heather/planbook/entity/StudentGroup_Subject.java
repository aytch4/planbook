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
public class StudentGroup_Subject {
  private int id;
  private int subjectId;
  private int studentGroupId;
  
  @JsonIgnore
  public int getId() {
    return id;
  }
}
