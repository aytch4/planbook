package staples.heather.planbook.service;

import java.util.List;
import staples.heather.planbook.entity.Unit;

public interface UnitService {

  List<Unit> fetchUnitsBySubjectByGrade(int subjectId, int gradeNumber);
  
//  List<Unit> listAllUnits();
//  
//  void deleteUnit(int id);
//  
//  void createUnit(String unitName, int subjectId, int gradeNumber);
//  
//  void updateUnit(String oldName, String newName);
//  
}
