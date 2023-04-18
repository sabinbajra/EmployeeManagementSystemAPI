package api.emscrud.controller;

import api.emscrud.model.Employee;
import api.emscrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //get employees
    @GetMapping
    List<Employee>  getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //get employee by id
    @GetMapping("/{id}")
    Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    //save employee
    //update employee by id
    //delete employee by id

}
