package staples.heather.planbook.service;

import java.util.List;
import staples.heather.planbook.entity.Unit;

public interface UnitService {

  List<Unit> fetchUnit(int id);
  
  List<Unit> listAllUnits();
  
  void deleteUnit(int id);
  
  void createUnit(String name, int subject_id);
  
  void updateUnit(String oldName, String newName);
  
}
