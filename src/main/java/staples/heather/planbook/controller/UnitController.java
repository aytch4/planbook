  package staples.heather.planbook.controller;

  import java.util.List;
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
import staples.heather.planbook.entity.Unit;

  @Validated
  @RequestMapping("/unit")
  @OpenAPIDefinition(info = @Info(title = "Planbook Service"), servers = {
      @Server(url = "http://localhost:8080", description = "Local server.")})

  public interface UnitController {

    //@formatter:off
    @Operation(
        summary = "Returns a Unit",
        description = "Returns a Unit",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A unit was returned", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Planbook.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The requested parameters were invalid", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No unit was found with the input criteria", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred", 
                content = @Content(mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "id", 
                allowEmptyValue = false, 
                required = true, 
                description = "The unit id"),
        }
     )
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Unit> fetchUnit(@RequestParam(required = true) int id);
  
    
    @Operation(
         summary = "Returns a list of Units",
         description = "Returns a list of Units",
         responses = {
             @ApiResponse(
                 responseCode = "200", 
                 description = "A list of units was returned", 
                 content = @Content(
                     mediaType = "application/json", 
                     schema = @Schema(implementation = Planbook.class))),
             @ApiResponse(
                 responseCode = "400", 
                 description = "The requested parameters were invalid", 
                 content = @Content(mediaType = "application/json")),
             @ApiResponse(
                 responseCode = "404", 
                 description = "No units were found with the input criteria", 
                 content = @Content(mediaType = "application/json")),
             @ApiResponse(
                 responseCode = "500", 
                 description = "An unplanned error occurred", 
                 content = @Content(mediaType = "application/json"))
         }
      )
    
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/all")
    List<Unit> listAllUnits();
     
    @Operation(
        summary = "Creates a Unit",
        description = "Creates a Unit",
        responses = {
            @ApiResponse(
                responseCode = "201", 
                description = "A unit was created", 
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
        }
      )
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    void createUnit(@RequestParam(required = true) String name, @RequestParam(required = true) int subjectId); 
    
    @Operation(
        summary = "Updates a Unit",
        description = "Updates a Unit",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A unit was updated", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Planbook.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The requested parameters were invalid", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No unit was found with the input criteria", 
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
                description = "The unit name (i.e., 'Geometry')"),
            @Parameter(
                name = "newName", 
                allowEmptyValue = false, 
                required = true, 
                description = "The new unit name (i.e., 'Fractions')")
        }
     )
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    void updateUnit(@RequestParam(required = true) String oldName, @RequestParam(required = true) String newName);
    
    @Operation(
        summary = "Deletes a Unit",
        description = "Deletes a Unit",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A unit was deleted", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Planbook.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The requested parameters were invalid", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No unit was found with the input criteria", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred", 
                content = @Content(mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "id", 
                allowEmptyValue = false, 
                required = true, 
                description = "The unit id"),
        }
     )
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping
    void deleteUnit(@RequestParam(required = true) int id); 
    

    //@formatter:on
  }