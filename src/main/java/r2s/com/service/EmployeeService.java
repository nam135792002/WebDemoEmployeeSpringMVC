package r2s.com.service;

import java.util.List;
import java.util.Optional;

import r2s.com.models.Employee;

public interface EmployeeService {
	Employee save(Employee employee);
	List<Employee> findAll();
	Optional<Employee> findById(int idEmployee);
	void deleteById(int idEmployee);
}
