package staples.heather.planbook.controller;

import java.util.List;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.entity.Lesson;
import staples.heather.planbook.service.LessonService;

@RestController
@Slf4j
public class BasicLessonController implements LessonController{

  @Autowired
  private LessonService lessonService;
  
  @Override
  public List<Lesson> fetchLesson(int id) {
    return lessonService.fetchLesson(id);
  }

  @Override
  public void createLesson(String name, String objective, String content, int unitId) {
    lessonService.createLesson(name, objective, content, unitId);
    
  }

  @Override
  public void updateLesson(int id, String newName, String newObjective, String newContent) {
    lessonService.updateLesson(id, newName, newObjective, newContent);
    
  }

  @Override
  public void deleteLesson(int id) {
    lessonService.deleteLesson(id);
  }

  @Override
  public List<Lesson> listAllLessons() {
    return lessonService.listAllLessons();
  }


}