package staples.heather.planbook.dao;

import java.util.List;
import staples.heather.planbook.entity.Unit;

public interface UnitDao {

  List<Unit> fetchUnit(int id);

  List<Unit> listAllUnits();

  void deleteUnit(int id);

  void createUnit(String name, int subject_id);

  void updateUnit(String oldName, String newName);
}
