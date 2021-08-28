package staples.heather.planbook.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.entity.Lesson;
import staples.heather.planbook.entity.StudentGroup;
import staples.heather.planbook.service.LessonService;
import staples.heather.planbook.service.StudentGroupService;

  @RestController
  @Slf4j
  public class BasicStudentGroupController implements StudentGroupController{

    @Autowired
    private StudentGroupService studentGroupService;
    
    @Override 
    public List<StudentGroup> fetchStudentGroup(String name) {
      return studentGroupService.fetchStudentGroup(name);
    }

    @Override
    public List<StudentGroup> listAllStudentGroups() {
      return studentGroupService.listAllStudentGroups();
    }

    @Override
    public void createStudentGroup(String name, int userId) {
      studentGroupService.createStudentGroup(name, userId);
    }

    @Override
    public void updateStudentGroup(String oldName, String newName) {
      studentGroupService.updateStudentGroup(oldName,  newName);
    }

    @Override
    public void deleteStudentGroup(String name) {
      studentGroupService.deleteStudentGroup(name);
    }
    
  }