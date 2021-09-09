package staples.heather.planbook.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.entity.Unit;
import staples.heather.planbook.service.UnitService;


@RestController
@Slf4j
public class BasicUnitController implements UnitController{

    @Autowired
    private UnitService unitService;
    
     @Override
     public List<Unit> fetchUnitsBySubjectByGrade(int subjectId, int gradeNumber) {
       return unitService.fetchUnitsBySubjectByGrade(subjectId, gradeNumber);
     }
//     
//    @Override
//     public List<Unit> listAllUnits() {
//       return unitService.listAllUnits();
//     }
//    
//    @Override
//    public void createUnit(String unitName, int subjectId, int gradeNumber) {
//      unitService.createUnit(unitName, subjectId, gradeNumber);
//    }
//    
//    @Override
//    public void updateUnit(String oldName, String newName) {
//      unitService.updateUnit(oldName, newName);
//    }
//    
//    public void deleteUnit(int id) {
//      unitService.deleteUnit(id);
//    }

}