package tech.getarrays.dbmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.getarrays.dbmanager.model.Dbmanager;

import java.util.Optional;

public interface DbmanagerRepo extends JpaRepository<Dbmanager, Long> {
    void deleteEmployeeById(Long id);

    Optional<Dbmanager> findEmployeeById(Long id);
}
