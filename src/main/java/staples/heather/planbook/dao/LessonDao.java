package staples.heather.planbook.dao;

import java.util.List;
import staples.heather.planbook.entity.Lesson;
import staples.heather.planbook.entity.Unit;

public interface LessonDao {

  List<Lesson> fetchLesson(int id);
  
  List<Lesson> listAllLessons();
  
  void createLesson(String name, String objective, String content, int unit_id);
  
  void updateLesson(int id, String newName, String newObjective, String newContent);
  
  void deleteLesson(int id);
}
