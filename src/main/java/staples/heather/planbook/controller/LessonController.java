package staples.heather.planbook.controller;

import java.util.List;
import java.util.NoSuchElementException;
import javax.validation.constraints.NotNull;
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
import staples.heather.planbook.dao.DefaultLessonDao;
import staples.heather.planbook.entity.Lesson;
import staples.heather.planbook.entity.Day;

@Validated
@RequestMapping("/lesson")
@OpenAPIDefinition(info = @Info(title = "Planbook Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface LessonController {

  //@formatter:off
  @Operation(
      summary = "Returns a Lesson",
      description = "Returns a Lesson",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A lesson was returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Planbook.class))),          
          @ApiResponse(
              responseCode = "404", 
              description = "No lesson was found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "lessonId", 
              allowEmptyValue = false, 
              required = true, 
              description = "The lesson id"),
      }
   )
  
  @GetMapping("/{lessonId}")
  @ResponseStatus(code = HttpStatus.OK)
  List<Lesson> fetchLessonById(
      @RequestParam(required = true) 
      int id);
 
  @Operation(
      summary = "Returns a List of Lessons by Unit",
      description = "Returns a List of Lessons by Unit",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of unit lessons was returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Planbook.class))),
//  
              
          @ApiResponse(
              responseCode = "404", 
              description = "No lessons were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "unitId", 
              allowEmptyValue = false, 
              required = true, 
              description = "The unit id"),
      }
   )
  
  @GetMapping("/{unitId}")
  @ResponseStatus(code = HttpStatus.OK)
  List<Lesson> fetchLessonsByUnit(
      @RequestParam(required = true) int unitId);
  
  
  
  @Operation(
      summary = "Returns a list of Lessons",
      description = "Returns a list of Lessons",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of lessons is returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Planbook.class))),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      }
   )
  
  @GetMapping("/all")
  @ResponseStatus(code = HttpStatus.OK)
  List<Lesson> listAllLessons();
    
 
  @Operation(
      summary = "Creates a Lesson",
      description = "Creates a Lesson",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "A lesson was created", 
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
              name = "lessonName", 
              allowEmptyValue = false, 
              required = true, 
              description = "The lesson name"),
          @Parameter(
              name = "objective", 
              allowEmptyValue = false, 
              required = true, 
              description = "The lesson objective"),
          @Parameter(
              name = "content", 
              allowEmptyValue = false, 
              required = true, 
              description = "The lesson content"),
          @Parameter(
              name = "unitId", 
              allowEmptyValue = false, 
              required = true, 
              description = "The unit id")
      }
   )
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping
  void createLesson(@RequestParam(required = true) String lessonName, @RequestParam(required = true) String objective, 
      @RequestParam(required = true) String content, @RequestParam(required = true) int unitId); 
  
  @Operation(
      summary = "Updates Lesson Content",
      description = "Updates Lesson Content",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A lesson's content was updated", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Planbook.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The requested parameters were invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No lesson was found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "lessonId", 
              allowEmptyValue = false, 
              required = true, 
              description = "The lesson id"),
          @Parameter(
              name = "newContent", 
              allowEmptyValue = false, 
              required = true, 
              description = "The new lesson content")
      }
   )
  @ResponseStatus(code = HttpStatus.OK)
  @PutMapping
  int updateLesson(@RequestParam(required = true) int lessonId, @RequestParam(required = true) String newContent);
  
  @Operation(
      summary = "Deletes a Lesson",
      description = "Deletes a Lesson",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A lesson was deleted", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Planbook.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The requested parameters were invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No lesson was found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "lessonId", 
              allowEmptyValue = false, 
              required = true, 
              description = "The lesson id"),
      }
   )
  @ResponseStatus(code = HttpStatus.OK)
  @DeleteMapping
  int deleteLesson(@RequestParam(required = true) int lessonId);
     
  }
 
 
  //@formatter:on

