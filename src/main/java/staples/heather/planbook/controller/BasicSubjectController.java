package staples.heather.planbook.controller;

import java.util.List;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.entity.Lesson;
import staples.heather.planbook.entity.Subject;
import staples.heather.planbook.entity.Day;
import staples.heather.planbook.service.LessonService;
import staples.heather.planbook.service.SubjectService;

  @RestController
  @Slf4j
  public class BasicSubjectController implements SubjectController{

    @Autowired
    private SubjectService subjectService;
    
//     @Override
//     public List<Subject> fetchSubject(String subjectName) {
//       return subjectService.fetchSubject(subjectName);
//     }
     @Override
     public List<Subject> listAllSubjects() {
       return subjectService.listAllSubjects();
     }

//    @Override
//    public void createSubject(String subjectName) {
//      subjectService.createSubject(subjectName);
//    }

//    @Override
//    public void updateSubject(String oldName, String newName) {
//      // TODO Auto-generated method stub
//      subjectService.updateSubject(oldName, newName);
//    }

//    @Override
//    public void deleteSubject(String subjectName) {
//      subjectService.deleteSubject(subjectName);
//      
//    }
     
  }