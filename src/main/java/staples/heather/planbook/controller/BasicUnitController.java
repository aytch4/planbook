package staples.heather.planbook.controller;

import java.util.List;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;
import staples.heather.planbook.Planbook;
import staples.heather.planbook.entity.Unit;
import staples.heather.planbook.entity.User;
import staples.heather.planbook.service.UnitService;
import staples.heather.planbook.service.UserService;

@RestController
@Slf4j
public class BasicUnitController implements UnitController{

    @Autowired
    private UnitService unitService;
    
     @Override
     public List<Unit> fetchUnit(int id) {
       return unitService.fetchUnit(id);
     }

     
    @Override
     public List<Unit> listAllUnits() {
       return unitService.listAllUnits();
     }
    
    @Override
    public void createUnit(String name, int subjectId) {
      unitService.createUnit(name, subjectId);
    }
    
    @Override
    public void updateUnit(String oldName, String newName) {
      unitService.updateUnit(oldName, newName);
    }
    
    public void deleteUnit(int id) {
      unitService.deleteUnit(id);
    }

}