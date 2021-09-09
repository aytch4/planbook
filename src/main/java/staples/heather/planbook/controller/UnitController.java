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
        summary = "Returns a List of Units by Subject by Grade",
        description = "Returns a List of Units by Subject by Grade",
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
                description = "No unit was found with the input criteria", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An unplanned error occurred", 
                content = @Content(mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "subjectId", 
                allowEmptyValue = false, 
                required = true, 
                description = "The subject id"),
            @Parameter(
                name = "gradeNumber", 
                allowEmptyValue = false, 
                required = true, 
                description = "The grade number"),
        }
     )
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Unit> fetchUnitsBySubjectByGrade(@RequestParam(required = true) int subjectId, @RequestParam(required = true) int gradeNumber);

    //@formatter:on
  }