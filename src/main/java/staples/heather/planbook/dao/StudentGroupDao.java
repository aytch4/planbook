package staples.heather.planbook.dao;

import java.util.List;
import staples.heather.planbook.entity.StudentGroup;
import staples.heather.planbook.entity.Unit;

public interface StudentGroupDao {

  List<StudentGroup> fetchStudentGroup(String name);

  List<StudentGroup> listAllStudentGroups();

  void deleteStudentGroup(String name);

  void createStudentGroup(String name, int user_id);

  void updateStudentGroup(String oldName, String newName);
}
