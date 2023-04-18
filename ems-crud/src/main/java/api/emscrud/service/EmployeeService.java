package api.emscrud.service;

import api.emscrud.exception.ResourceNotFoundException;
import api.emscrud.model.Employee;
import api.emscrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(@Autowired EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) throws ResourceNotFoundException {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Employee createEmployee(Employee fromClient) {
        return employeeRepository.save(fromClient);
    }

    public Employee updateEmployee(Employee result) {
        return employeeRepository.save(result);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }
}
