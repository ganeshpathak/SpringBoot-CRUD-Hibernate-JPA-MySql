package in.ganeshpathak.springboot.crudapi.controller;

import in.ganeshpathak.springboot.crudapi.dao.EmployeeDAO;
import in.ganeshpathak.springboot.crudapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;

	
	@GetMapping("/employee")
	public List<Employee> get(){
		return employeeDAO.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		Optional<Employee> employeeObj = employeeDAO.findById(id);
		if(employeeObj.isPresent()) {
			return employeeObj.get();
		}else {
			throw new RuntimeException("Employee not found for the Id:" + id);
		}
	}

	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employeeObj) {
		return employeeDAO.save(employeeObj);
	}

	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employeeObj) {
		return employeeDAO.save(employeeObj);
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		Optional<Employee> employee = employeeDAO.findById(id);
		if(employee.isPresent()) {
			employeeDAO.delete(employee.get());
			return "Employee is deleted with id "+id;
		}else {
			throw new RuntimeException("Employee not found for the id "+id);
		}
	}
}
