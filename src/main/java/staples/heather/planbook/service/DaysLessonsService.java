package staples.heather.planbook.service;

import java.util.List;
import staples.heather.planbook.entity.Day;
import staples.heather.planbook.entity.Grade;
import staples.heather.planbook.entity.Lesson;

public interface DaysLessonsService {

  List<Lesson> fetchLessonsByDay(String dayOfTheWeek);

  List<Day> listWeeksLessons();

  int updateDayOfLesson(int lessonId, int newDay);

  void clearWeeksLessons();

  int deleteLessonFromDay(int lessonId);

  void assignLessonsToDay(int dayId, int lessonId);

 
  
 
}