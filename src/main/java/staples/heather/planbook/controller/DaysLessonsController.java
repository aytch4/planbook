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
import staples.heather.planbook.entity.Day;
import staples.heather.planbook.entity.Grade;
import staples.heather.planbook.entity.Lesson;

  @Validated
  @RequestMapping("/daysLessons")
  @OpenAPIDefinition(info = @Info(title = "Planbook Service"), servers = {
      @Server(url = "http://localhost:8080", description = "Local server.")})

  public interface DaysLessonsController {

    //@formatter:off
    @Operation(
        summary = "Returns a list of Lessons for the Day",
        description = "Returns a list of Lessons for the Day",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A list of lessons was returned", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Planbook.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The requested parameters were invalid", 
                content = @Content(mediaType = "application/json")),
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
                name = "dayOfTheWeek", 
                allowEmptyValue = false, 
                required = true, 
                description = "The day of the week (i.e., 'Monday')"),
        }
     )
    
    @GetMapping("/{dayOfTheWeek}")
    @ResponseStatus(code = HttpStatus.OK)
    List<Lesson> fetchLessonsByDay(
      @RequestParam(required = true)
      String dayOfTheWeek);


    @Operation(
         summary = "Returns a list of Lessons for the Week",
         description = "Returns a list of Lessons for the Week",
         responses = {
             @ApiResponse(
                 responseCode = "200", 
                 description = "A list of lessons was returned", 
                 content = @Content(
                     mediaType = "application/json", 
                     schema = @Schema(implementation = Planbook.class))),
             @ApiResponse(
                 responseCode = "400", 
                 description = "The requested parameters were invalid", 
                 content = @Content(mediaType = "application/json")),
             @ApiResponse(
                 responseCode = "404", 
                 description = "No lessons were found with the input criteria", 
                 content = @Content(mediaType = "application/json")),
             @ApiResponse(
                 responseCode = "500", 
                 description = "An unplanned error occurred", 
                 content = @Content(mediaType = "application/json"))
         }
         
      )
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/all")
    List<Day> listWeeksLessons();
     
    @Operation(
        summary = "Assigns Lesson to Day",
        description = "Assigns Lesson to Day",
        responses = {
            @ApiResponse(
                responseCode = "201", 
                description = "A lesson was assigned to a day", 
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
                name = "dayId", 
                allowEmptyValue = false, 
                required = true, 
                description = "The day id (i.e., '1')"),
            @Parameter(
                name = "lessonId", 
                allowEmptyValue = false, 
                required = true, 
                description = "The lesson id"),
        }
     )
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    void assignLessonsToDay(@RequestParam(required = true) int dayId, @RequestParam(required = true) int lessonId);
    
    @Operation(
        summary = "Updates the Day of a Lesson",
        description = "Updates the Day of a Lesson",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A lesson was rescheduled for another day", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Planbook.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The requested parameters were invalid", 
                content = @Content(mediaType = "application/json")),
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
                name = "lessonId", 
                allowEmptyValue = false, 
                required = true, 
                description = "The id of lesson to be rescheduled"),
            @Parameter(
                name = "newDay", 
                allowEmptyValue = false, 
                required = true, 
                description = "The id of the day to schedule the lesson")
        }
     )
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    int updateDayOfLesson(@RequestParam(required = true) int lessonId, @RequestParam(required = true) int newDay);
    
    @Operation(
        summary = "Clears the Week's schedule of Lessons",
        description = "Clears the Week's schedule of Lessons",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "The week's lessons were cleared", 
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
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/all")
    void clearWeeksLessons(); 

    @Operation(
        summary = "Unschedules a Lesson",
        description = "Unschedules a Lesson",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A lesson is no longer scheduled for a particular day", 
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
    int deleteLessonFromDay(@RequestParam(required = true) int lessonId); 
    
    //@formatter:on
     }

