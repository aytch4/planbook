package staples.heather.planbook.dao;

import java.util.List;
import staples.heather.planbook.entity.Subject;
import staples.heather.planbook.entity.Unit;

public interface SubjectDao {

  List<Subject> fetchSubject(String name);
  
  List<Subject> listAllSubjects();
  
  void createSubject(String name);

  void updateSubject(String oldName, String newName);
  
  void deleteSubject(String name);

}
