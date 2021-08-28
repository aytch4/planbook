package staples.heather.planbook.service;

  import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.dao.LessonDao;
import staples.heather.planbook.entity.Lesson;

  @Service
  @Slf4j
  public class DefaultLessonService implements LessonService {

    @Autowired
    private LessonDao lessonDao;
    
    @Override
    public List<Lesson> fetchLesson(int id) {
      List<Lesson> lesson = lessonDao.fetchLesson(id);
      return lesson;
    }

    @Override
    public List<Lesson> listAllLessons() {
      List<Lesson> lessons = lessonDao.listAllLessons();
      return lessons;
    }
    
    @Override
    public void createLesson(String name, String objective, String content, int unitId) {
      lessonDao.createLesson(name,  objective,  content, unitId);
    }
    
    @Override
    public void updateLesson(int id, String newName, String newObjective, String newContent) {
      lessonDao.updateLesson(id, newName, newObjective, newContent);
    }
    
    public void deleteLesson(int id) {
      lessonDao.deleteLesson(id);
    }
  }