package tech.getarrays.dbmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.getarrays.dbmanager.exception.UserNotFoundException;
import tech.getarrays.dbmanager.model.Dbmanager;
import tech.getarrays.dbmanager.repo.DbmanagerRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DbmanagerService {
    private final DbmanagerRepo dbmanagerRepo;

    @Autowired
    public DbmanagerService(DbmanagerRepo dbmanagerRepo) {
        this.dbmanagerRepo = dbmanagerRepo;
    }

    public Dbmanager addEmployee(Dbmanager dbmanager) {
        dbmanager.setEmployeeCode(UUID.randomUUID().toString());
        return dbmanagerRepo.save(dbmanager);
    }

    public List<Dbmanager> findAllEmployees() {
        return dbmanagerRepo.findAll();
    }

    public Dbmanager updateEmployee(Dbmanager dbmanager) {
        return dbmanagerRepo.save(dbmanager);
    }

    public Dbmanager findEmployeeById(Long id) {
        return dbmanagerRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id){
        dbmanagerRepo.deleteEmployeeById(id);
    }
}
