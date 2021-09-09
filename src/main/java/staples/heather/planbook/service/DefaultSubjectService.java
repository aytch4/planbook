package staples.heather.planbook.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.dao.SubjectDao;
import staples.heather.planbook.entity.Subject;

@Service
@Slf4j
public class DefaultSubjectService implements SubjectService{


  @Autowired
  private SubjectDao subjectDao;

//  @Override
//  public List<Subject> fetchSubject(String subjectName) {
//    List<Subject> subject = subjectDao.fetchSubject(subjectName);
//    return subject;
//  }

  @Override
  public List<Subject> listAllSubjects() {
    List<Subject> subjects = subjectDao.listAllSubjects();
    return subjects;
  }

//  @Override
//  public void createSubject(String subjectName) {
//    subjectDao.createSubject(subjectName);
//  }

//  @Override
//  public void updateSubject(String oldName, String newName) {
//    subjectDao.updateSubject(oldName, newName);
//  }

//  @Override
//  public void deleteSubject(String subjectName) {
//    subjectDao.deleteSubject(subjectName);
//    
//  }
}

