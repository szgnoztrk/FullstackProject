package dev.patika.app.controller;

import dev.patika.app.business.EmployeeService;
import dev.patika.app.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;
    @GetMapping
    public List<Employee> getAllEmployees(){
        return this.service.getAllEmployees();
    }

    @PostMapping
    public void save(@RequestBody @Valid Employee employee){
        this.service.saveEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable Long employeeId){
        this.service.deleteEmployee(employeeId);
    }
}
