package staples.heather.planbook.dao;

import java.util.List;
import staples.heather.planbook.entity.Unit;

public interface UnitDao {

  List<Unit> fetchUnitsBySubjectByGrade(int subjectId, int gradeNumber);

//  List<Unit> listAllUnits();
//
//  void deleteUnit(int id);
//
//  void createUnit(String unitName, int subjectId, int gradeNumber);
//
//  void updateUnit(String oldName, String newName);
}
