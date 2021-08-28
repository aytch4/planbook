package staples.heather.planbook.controller.support;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import staples.heather.planbook.entity.StudentGroup;
import staples.heather.planbook.entity.User;

public class FetchUserTestSupport extends BaseTest {
  protected List<User> buildExpected() {
    List<User> list = new LinkedList<>();
    
    list.add(User.builder()
        .name("Donovan")
        .build());
    
    list.add(User.builder()
        .name("Jacobs")
        .build());
    
    //@formatter:on
    return list;
  }  
  
  protected void assertErrorMessageValid(Map<String, Object> error, HttpStatus status) {
    //formatter:off
    assertThat(error)
      .containsKey("message")
      .containsEntry("status code", status.value())
//      .containsEntry("uri", "/planbook")
      .containsKey("timestamp")
      .containsEntry("reason", status.getReasonPhrase());
    //formatter:on
  }
}
