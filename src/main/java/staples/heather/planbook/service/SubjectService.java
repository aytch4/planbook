package staples.heather.planbook.service;

import java.util.List;
import staples.heather.planbook.entity.Subject;

public interface SubjectService {

  List<Subject> fetchSubject(String name);
  
  List<Subject> listAllSubjects();
  
  void createSubject(String name);
  
  void updateSubject(String oldName, String newName);
  
  void deleteSubject(String name);
  
}
