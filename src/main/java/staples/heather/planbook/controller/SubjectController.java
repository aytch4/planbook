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
import staples.heather.planbook.entity.Subject;
import staples.heather.planbook.entity.User;

  @Validated
  @RequestMapping("/subject")
  @OpenAPIDefinition(info = @Info(title = "Planbook Service"), servers = {
      @Server(url = "http://localhost:8080", description = "Local server.")})

  public interface SubjectController {
    public static final int NAME_MAX_LENGTH = 25;

    //@formatter:off
    @Operation(
        summary = "Returns a Subject",
        description = "Returns a Subject",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A subject was returned", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Planbook.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The requested parameters were invalid", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No subject was found with the input criteria", 
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
                description = "The subject name (i.e., 'Math')"),
        }
     )
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Subject> fetchSubject(
        @Length(max = NAME_MAX_LENGTH)
        @Pattern(regexp = "[\\w\\s]*")
        @RequestParam(required = true) String name);
  
    
    @Operation(
         summary = "Returns a list of Subjects",
         description = "Returns a list of Subjects",
         responses = {
             @ApiResponse(
                 responseCode = "200", 
                 description = "A list of subjects was returned", 
                 content = @Content(
                     mediaType = "application/json", 
                     schema = @Schema(implementation = Planbook.class))),
             @ApiResponse(
                 responseCode = "400", 
                 description = "The requested parameters were invalid", 
                 content = @Content(mediaType = "application/json")),
             @ApiResponse(
                 responseCode = "404", 
                 description = "No subjects were found with the input criteria", 
                 content = @Content(mediaType = "application/json")),
             @ApiResponse(
                 responseCode = "500", 
                 description = "An unplanned error occurred", 
                 content = @Content(mediaType = "application/json"))
         }
      )
    
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/all")
    List<Subject> listAllSubjects();
     
    @Operation(
        summary = "Creates a Subject",
        description = "Creates a Subject",
        responses = {
            @ApiResponse(
                responseCode = "201", 
                description = "A subject was created", 
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
                description = "The subject name (i.e., 'Math')")
        }
     )
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    void createSubject(@RequestParam(required = true) String name); 
    
    @Operation(
        summary = "Updates a Subject",
        description = "Updates a Subject",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A subject was updated", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Planbook.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The requested parameters were invalid", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No subject was found with the input criteria", 
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
                description = "The subject name (i.e., 'Mathematics')"),
            @Parameter(
                name = "newName", 
                allowEmptyValue = false, 
                required = true, 
                description = "The new subject name (i.e., 'Math')")
        }
     )
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    void updateSubject(@RequestParam(required = true) String oldName, @RequestParam(required = true) String newName);
    
    @Operation(
        summary = "Deletes a Subject",
        description = "Deletes a Subject",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A subject was deleted", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Planbook.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The requested parameters were invalid", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No subject was found with the input criteria", 
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
                description = "The subject name (i.e., 'Math')"),
        }
     )
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping
    void deleteSubject(@RequestParam(required = true) String name); 
    

    //@formatter:on
  }
