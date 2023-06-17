package r2s.com.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r2s.com.models.Employee;
import r2s.com.reponsitory.EmployeeReponsitory;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeReponsitory employeeReponsitory;
	
	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeReponsitory.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeReponsitory.findAll();
	}

	@Override
	public Optional<Employee> findById(int idEmployee) {
		// TODO Auto-generated method stub
		return employeeReponsitory.findById(idEmployee);
	}

	@Override
	public void deleteById(int idEmployee) {
		// TODO Auto-generated method stub
		employeeReponsitory.deleteById(idEmployee);
	}

}
