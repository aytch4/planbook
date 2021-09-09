  package staples.heather.planbook.controller;

  import java.util.List;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.RestController;
  import lombok.extern.slf4j.Slf4j;
  import staples.heather.planbook.entity.Lesson;
import staples.heather.planbook.entity.Day;
import staples.heather.planbook.entity.Grade;
  import staples.heather.planbook.service.LessonService;
  import staples.heather.planbook.service.DaysLessonsService;

    @RestController
    @Slf4j
    public class BasicDaysLessonsController implements DaysLessonsController{

      @Autowired
      private DaysLessonsService daysLessonsService;
      
           
      public List<Lesson> fetchLessonsByDay(String dayOfTheWeek) {
        return daysLessonsService.fetchLessonsByDay(dayOfTheWeek);
      }

      public List<Day> listWeeksLessons() {
        return daysLessonsService.listWeeksLessons();
      }

      public void assignLessonsToDay(int dayId, int lessonId) {
        daysLessonsService.assignLessonsToDay(dayId, lessonId);
      }

      public int updateDayOfLesson(int lessonId, int newDay) {
        return daysLessonsService.updateDayOfLesson(lessonId, newDay);
      }

      public void clearWeeksLessons() {
        daysLessonsService.clearWeeksLessons();
      }
      
      public int deleteLessonFromDay(int lessonId) {
        return daysLessonsService.deleteLessonFromDay(lessonId);
      }
      
    }
