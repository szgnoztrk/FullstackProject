package dev.patika.app.dao;

import dev.patika.app.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
    boolean existsAllById(long id);
    boolean existsAllByEmail(String email);
}
