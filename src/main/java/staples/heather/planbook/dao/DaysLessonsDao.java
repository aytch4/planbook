package staples.heather.planbook.dao;

import java.util.List;
import staples.heather.planbook.entity.Day;
import staples.heather.planbook.entity.Grade;
import staples.heather.planbook.entity.Lesson;
import staples.heather.planbook.entity.Unit;

public interface DaysLessonsDao {

  List<Day> listWeeksLessons();

  List<Lesson> fetchLessonsByDay(String dayOfTheWeek);

  void assignLessonsToDay(int dayId, int lessonId);

  void clearWeeksLessons();

  int deleteLessonFromDay(int lessonId);

  int updateDayOfLesson(int lessonId, int newDay);

  //void deleteLessonByDay(int dayId);
}
