package staples.heather.planbook.controller;

import java.util.List;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import staples.heather.planbook.Planbook;
import staples.heather.planbook.entity.User;

@Validated
@RequestMapping("/user")
@OpenAPIDefinition(info = @Info(title = "Planbook Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface UserController {
  public static final int NAME_MAX_LENGTH = 25;

  //@formatter:off
  @Operation(
      summary = "Returns a User",
      description = "Returns a User",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A user is returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Planbook.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The requested parameters were invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No user was found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "name", 
              allowEmptyValue = false, 
              required = false, 
              description = "The user name (i.e., 'Staples')"),
      }
   )
  @GetMapping
  List<User> fetchUser(
      @Length(max = NAME_MAX_LENGTH)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = true) 
      String name);
  
  @Operation(
       summary = "Returns a list of Users",
       description = "Returns a list of Users",
       responses = {
           @ApiResponse(
               responseCode = "200", 
               description = "A list of users is returned", 
               content = @Content(
                   mediaType = "application/json", 
                   schema = @Schema(implementation = Planbook.class))),
           @ApiResponse(
               responseCode = "400", 
               description = "The requested parameters were invalid", 
               content = @Content(mediaType = "application/json")),
           @ApiResponse(
               responseCode = "404", 
               description = "No users were found with the input criteria", 
               content = @Content(mediaType = "application/json")),
           @ApiResponse(
               responseCode = "500", 
               description = "An unplanned error occurred", 
               content = @Content(mediaType = "application/json"))
       }
       
    )
  @ResponseStatus(code = HttpStatus.OK)
  @GetMapping("/all")
  List<User> listAllUsers();
   
  @Operation(
      summary = "Creates a User",
      description = "Creates a User",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "A user was created", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Planbook.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The requested parameters were invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "name", 
              allowEmptyValue = false, 
              required = false, 
              description = "The user name (i.e., 'Staples')"),
      }
   )
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping
  void createUser(@RequestParam(required = true) String name); 
  
  @Operation(
      summary = "Updates a User",
      description = "Updates a User",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A user was updated", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Planbook.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The requested parameters were invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No user was found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "oldName", 
              allowEmptyValue = false, 
              required = true, 
              description = "The user name (i.e., 'Crosby')"),
          @Parameter(
              name = "newName", 
              allowEmptyValue = false, 
              required = true, 
              description = "The new user name (i.e., 'Staples')")
      }
   )
  @ResponseStatus(code = HttpStatus.OK)
  @PutMapping
  void updateUser(@RequestParam(required = true) String newName, @RequestParam(required = true) String oldName);
  
  @Operation(
      summary = "Deletes a User",
      description = "Deletes a User",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A user was deleted", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Planbook.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The requested parameters were invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No user was found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "name", 
              allowEmptyValue = false, 
              required = false, 
              description = "The user name (i.e., 'Staples')"),
      }
   )
  @ResponseStatus(code = HttpStatus.OK)
  @DeleteMapping
  void deleteUser(@RequestParam(required = true) String name);

  

  //@formatter:on
}
