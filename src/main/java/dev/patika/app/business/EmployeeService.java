package dev.patika.app.business;

import dev.patika.app.dao.EmployeeDao;
import dev.patika.app.exceptions.EmployeeAlreadyExistsException;
import dev.patika.app.exceptions.EmployeeNotFoundException;
import dev.patika.app.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeDao dao;

    public List<Employee> getAllEmployees(){
        return this.dao.findAll();
    }
    public void saveEmployee(Employee employee) {
        if(this.dao.existsAllByEmail(employee.getEmail()))
            throw new EmployeeAlreadyExistsException("Employee with E-mail: ( "+ employee.getEmail() + " ) is already exists!");
        this.dao.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        if(!this.dao.existsAllById(employeeId))
            throw new EmployeeNotFoundException("Employee with ID: " + employeeId + " could not foud!");
        this.dao.deleteById(employeeId);
    }
}
