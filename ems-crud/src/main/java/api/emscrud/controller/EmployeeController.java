package api.emscrud.controller;

import api.emscrud.exception.ResourceNotFoundException;
import api.emscrud.model.Employee;
import api.emscrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //get employees
    @GetMapping("employees")
    List<Employee>  getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //get employee by id
    @GetMapping("/employees/{id}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee result = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok().body(result);
    }

    //save employee
    @PostMapping("/employees")
    Employee createEmployee(@RequestBody Employee fromClient)
    {
        return employeeService.createEmployee(fromClient);
    }

    //update employee by id
    @PutMapping("/employees/{id}")
    ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long employeeId, @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee result = employeeService.getEmployeeById(employeeId);

        result.setFirstName(employeeDetails.getFirstName());
        result.setLastName(employeeDetails.getLastName());
        result.setAddress(employeeDetails.getAddress());
        result.setAge(employeeDetails.getAge());
        result.setEmail(employeeDetails.getEmail());

        return ResponseEntity.ok(employeeService.updateEmployee(result));
    }

    //delete employee by id
    @DeleteMapping("/employees/{id}")
    Map<String, Boolean> deleteEmployee(@PathVariable(value="id")Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeService.getEmployeeById(employeeId);
        employeeService.deleteEmployee(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

}
