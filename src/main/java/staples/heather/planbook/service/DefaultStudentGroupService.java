package staples.heather.planbook.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.dao.StudentGroupDao;
import staples.heather.planbook.entity.StudentGroup;

@Service
@Slf4j
public class DefaultStudentGroupService implements StudentGroupService{

  @Autowired
  private StudentGroupDao studentGroupDao;

  @Override
  public List<StudentGroup> fetchStudentGroup(String name) {
    List<StudentGroup> studentGroup = studentGroupDao.fetchStudentGroup(name);
    return studentGroup;
  }
  
  @Override
  public List<StudentGroup> listAllStudentGroups() {
    List<StudentGroup> studentGroups = studentGroupDao.listAllStudentGroups();
    return studentGroups;
  }
  
  @Override
  public void createStudentGroup(String name, int userId) {
    studentGroupDao.createStudentGroup(name, userId);
  }
  
  @Override
  public void updateStudentGroup(String oldName, String newName) {
    studentGroupDao.updateStudentGroup(oldName, newName);
  }

  public void deleteStudentGroup(String name) {
    studentGroupDao.deleteStudentGroup(name);
  }
  
}