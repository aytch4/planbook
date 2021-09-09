package staples.heather.planbook.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.dao.DaysLessonsDao;
import staples.heather.planbook.entity.Day;
import staples.heather.planbook.entity.Grade;
import staples.heather.planbook.entity.Lesson;

@Service
@Slf4j
public class DefaultDaysLessonsService implements DaysLessonsService{

  @Autowired
  private DaysLessonsDao daysLessonsDao;
  
  
  @Override
  public List<Lesson> fetchLessonsByDay(String dayOfTheWeek) {
    List<Lesson> lessonsByDay = daysLessonsDao.fetchLessonsByDay(dayOfTheWeek);
    return lessonsByDay;
  }
  
  @Override
  public List<Day> listWeeksLessons() {
    List<Day> lessonsForWeek = daysLessonsDao.listWeeksLessons();
    return lessonsForWeek;
  }
  
  @Override
  public void assignLessonsToDay(int dayId, int lessonId) {
    daysLessonsDao.assignLessonsToDay(dayId, lessonId);
  }
  
  @Override
  public int updateDayOfLesson(int lessonId, int newDay) {
    return daysLessonsDao.updateDayOfLesson(lessonId, newDay);
  }

  public int deleteLessonFromDay(int lessonId) {
    return daysLessonsDao.deleteLessonFromDay(lessonId);
  }
  
  public void clearWeeksLessons() {
    daysLessonsDao.clearWeeksLessons();
  }
  
}