package staples.heather.planbook.service;

import java.util.List;
import staples.heather.planbook.entity.Lesson;

public interface LessonService {

  List<Lesson> fetchLesson(int id);

  List<Lesson> listAllLessons();

  void createLesson(String name, String objective, String content, int unitId);

  void updateLesson(int id, String newName, String newObjective, String newContent);
  
  void deleteLesson(int id);
}

