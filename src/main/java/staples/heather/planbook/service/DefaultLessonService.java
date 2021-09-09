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
    public List<Lesson> fetchLessonById(int lessonId) {
      List<Lesson> lesson = lessonDao.fetchLessonById(lessonId);
      return lesson;
    }

    @Override
    public List<Lesson> fetchLessonsByUnit(int unitId) {
      List<Lesson> lessons = lessonDao.fetchLessonsByUnit(unitId);
      return lessons;
    }
    
    @Override
    public List<Lesson> listAllLessons() {
      List<Lesson> lessons = lessonDao.listAllLessons();
      return lessons;
    }
    
    @Override
    public void createLesson(String lessonName, String objective, String content, int unitId) {
      lessonDao.createLesson(lessonName,  objective,  content, unitId);
    }
    
    @Override
    public int updateLesson(int id, String newContent) {
      return lessonDao.updateLesson(id, newContent);
    }
    
    public int deleteLesson(int id) {
      return lessonDao.deleteLesson(id);
    }
  }