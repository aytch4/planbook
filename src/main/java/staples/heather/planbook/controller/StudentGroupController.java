package staples.heather.planbook.controller;

import java.util.List;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import staples.heather.planbook.Planbook;
import staples.heather.planbook.entity.StudentGroup;

@Validated
@RequestMapping("/studentGroup")
@OpenAPIDefinition(info = @Info(title = "Planbook Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface StudentGroupController {

  //@formatter:off
  @Operation(
      summary = "Returns a StudentGroup",
      description = "Returns a StudentGroup",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A student group was returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Planbook.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The requested parameters were invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No student group was found with the input criteria", 
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
              required = true, 
              description = "The student group name (i.e., '2A')"),
      }
   )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<StudentGroup> fetchStudentGroup(
    @Length(max = 3)
    @Pattern(regexp = "[\\A-Z\\0-9]*")
    @RequestParam(required = true)
    String name);


  @Operation(
       summary = "Returns a list of Student Groups",
       description = "Returns a list of Student Groups",
       responses = {
           @ApiResponse(
               responseCode = "200", 
               description = "A list of student groups was returned", 
               content = @Content(
                   mediaType = "application/json", 
                   schema = @Schema(implementation = Planbook.class))),
           @ApiResponse(
               responseCode = "400", 
               description = "The requested parameters were invalid", 
               content = @Content(mediaType = "application/json")),
           @ApiResponse(
               responseCode = "404", 
               description = "No student groups were found with the input criteria", 
               content = @Content(mediaType = "application/json")),
           @ApiResponse(
               responseCode = "500", 
               description = "An unplanned error occurred", 
               content = @Content(mediaType = "application/json"))
       }
       
    )
  @ResponseStatus(code = HttpStatus.OK)
  @GetMapping("/all")
  List<StudentGroup> listAllStudentGroups();
   
  @Operation(
      summary = "Creates a Student Group",
      description = "Creates a Student Group",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "A student group was created", 
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
              required = true, 
              description = "The student group name (i.e., '2A')"),
          @Parameter(
              name = "userId", 
              allowEmptyValue = false, 
              required = true, 
              description = "The userId"),
      }
   )
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping
  void createStudentGroup(@RequestParam(required = true) String name, @RequestParam(required = true) int userId); 
  
  @Operation(
      summary = "Updates a Student Group",
      description = "Updates a Student Group",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A student group was updated", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Planbook.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The requested parameters were invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No student group was found with the input criteria", 
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
              description = "The student group name (i.e., '1A')"),
          @Parameter(
              name = "newName", 
              allowEmptyValue = false, 
              required = true, 
              description = "The new student group name (i.e., '2A')")
      }
   )
  @ResponseStatus(code = HttpStatus.OK)
  @PutMapping
  void updateStudentGroup(@RequestParam(required = true) String oldName, @RequestParam(required = true) String newName);
  
  @Operation(
      summary = "Deletes a StudentGroup",
      description = "Deletes a StudentGroup",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A student group was deleted", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Planbook.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The requested parameters were invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No student group was found with the input criteria", 
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
              required = true, 
              description = "The student group name (i.e., '2A')"),
      }
   )
  @ResponseStatus(code = HttpStatus.OK)
  @DeleteMapping
  void deleteStudentGroup(@RequestParam(required = true) String name); 

  //@formatter:on
}