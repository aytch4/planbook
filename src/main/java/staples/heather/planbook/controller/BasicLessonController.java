package staples.heather.planbook.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
  public List<Lesson> fetchLessonById(int lessonId) {
    return lessonService.fetchLessonById(lessonId);
  }

  @Override
  public List<Lesson> fetchLessonsByUnit(int unitId) {
    return lessonService.fetchLessonsByUnit(unitId);
  }
  
  @Override
  public void createLesson(String lessonName, String objective, String content, int unitId) {
    lessonService.createLesson(lessonName, objective, content, unitId);
  }

  @Override
  public int updateLesson(int lessonId, String newContent) {
    return lessonService.updateLesson(lessonId, newContent);
  }

  @Override
  public int deleteLesson(int lessonId) {
    return lessonService.deleteLesson(lessonId);
      
    }
  
  @Override
  public List<Lesson> listAllLessons() {
    return lessonService.listAllLessons();
  }
}