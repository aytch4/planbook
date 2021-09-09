package staples.heather.planbook.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.dao.UnitDao;
import staples.heather.planbook.entity.Unit;

@Service
@Slf4j
public class DefaultUnitService implements UnitService{


  @Autowired
  private UnitDao unitDao;

  @Override
  public List<Unit> fetchUnitsBySubjectByGrade(int subjectId, int gradeNumber) {
    List<Unit> units = unitDao.fetchUnitsBySubjectByGrade(subjectId, gradeNumber);
    return units;
  }
//
//  @Override
//  public List<Unit> listAllUnits() {
//    List<Unit> units = unitDao.listAllUnits();
//    return units;
//  }
//
//  @Override
//  public void createUnit(String unitName, int subjectId, int gradeNumber) {
//    unitDao.createUnit(unitName,  subjectId, gradeNumber);
//  }
//
//  @Override
//  public void updateUnit(String oldName, String newName) {
//    unitDao.updateUnit(oldName,  newName);
//  }
//  
//  @Override
//  public void deleteUnit(int id) {
//    unitDao.deleteUnit(id);
//  }
//  
}
