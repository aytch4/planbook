package staples.heather.planbook.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import staples.heather.planbook.controller.support.FetchUserTestSupport;
import staples.heather.planbook.entity.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(
    scripts = {"classpath:planbook-schema.sql",
      "classpath:planbookDB.sql"},
    config = @SqlConfig(encoding = "utf-8"))
class FetchUserTest extends FetchUserTestSupport {
  
  @Test
  void testThatAValidUserWillBeReturnedWhenGivenAUser() {
  //Given (just starting out basic test)
    String name = "Staples";
    String uri = 
        String.format("%s?name=%s", getBaseUri(), name);
    
    //When: a connection is made to the URI
    ResponseEntity<List<User>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
    System.out.println(response);
    //Then: a success (OK - 200) status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
 
    //And: the actual list is the same as the expected list
    List<User> actual = response.getBody();
    List<User> expected = buildExpected();
    
    assertThat(actual).isEqualTo(expected);
  }
    
  
  @Test
  void testThatAnErrorMessageIsReturnedWhenAnUnknownNameIsSupplied() {
  //Given (just starting out basic test)
    String name = "Invalid Value";
    String uri = 
        String.format("%s?name=%s", getBaseUri(), name);
    
    //When: a connection is made to the URI
    ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
    System.out.println(response);
    
    //Then: a not found (404) status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
 
    //And: the error message is returned
    Map<String, Object> error = response.getBody();
    
    assertErrorMessageValid(error, HttpStatus.NOT_FOUND);
  }
     

@ParameterizedTest
@MethodSource("staples.heather.planbook.controller.FetchUserTest#parametersForInvalidInput")
void testThatAnErrorMessageIsReturnedWhenAnInvalidValueIsSupplied(String name, String reason) {
//Given (just starting out basic test)
  String uri = 
      String.format("%s?name=%s", getBaseUri(), name);
  
  //When: a connection is made to the URI
  ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

  //Then: a not found (400) status code is returned
  assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

  //And: the error message is returned
  Map<String, Object> error = response.getBody();
  
  assertErrorMessageValid(error, HttpStatus.BAD_REQUEST);
}

   static Stream<Arguments> parametersForInvalidInput() {
     return Stream.of(
         arguments("Invalid!", "User name is invalid")
         );
   }
}
