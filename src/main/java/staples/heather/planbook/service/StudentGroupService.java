package staples.heather.planbook.service;

import java.util.List;
import staples.heather.planbook.entity.StudentGroup;

public interface StudentGroupService {
  
  List<StudentGroup> fetchStudentGroup(String name);

  List<StudentGroup> listAllStudentGroups();

  void createStudentGroup(String name, int userId);

  void updateStudentGroup(String oldName, String newName);
  
  void deleteStudentGroup(String name);
  
}