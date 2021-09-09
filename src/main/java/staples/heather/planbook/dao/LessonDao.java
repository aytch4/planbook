package staples.heather.planbook.dao;

import java.util.List;
import staples.heather.planbook.entity.Lesson;
import staples.heather.planbook.entity.Unit;

public interface LessonDao {

  List<Lesson> fetchLessonById(int lessonId);
  
  List<Lesson> fetchLessonsByUnit(int unitId);  
  
  List<Lesson> listAllLessons();
  
  void createLesson(String lessonName, String objective, String content, int unitId);
  
  int updateLesson(int lessonId, String newContent);
  
  int deleteLesson(int lessonId);
}
