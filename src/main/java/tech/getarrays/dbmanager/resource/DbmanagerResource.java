package tech.getarrays.dbmanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.getarrays.dbmanager.model.Dbmanager;
import tech.getarrays.dbmanager.service.DbmanagerService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class DbmanagerResource {
    private final DbmanagerService dbmanagerService;

    public DbmanagerResource(DbmanagerService dbmanagerService) {
        this.dbmanagerService = dbmanagerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Dbmanager>> getAllEmployees () {
        List<Dbmanager> dbmanagers = dbmanagerService.findAllEmployees();
        return new ResponseEntity<>(dbmanagers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Dbmanager> getEmployeeById (@PathVariable("id") Long id) {
        Dbmanager dbmanager = dbmanagerService.findEmployeeById(id);
        return new ResponseEntity<>(dbmanager, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Dbmanager> addEmployee(@RequestBody Dbmanager dbmanager) {
        Dbmanager newEmployee = dbmanagerService.addEmployee(dbmanager);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Dbmanager> updateEmployee(@RequestBody Dbmanager dbmanager) {
        Dbmanager updateEmployee = dbmanagerService.updateEmployee(dbmanager);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        dbmanagerService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
