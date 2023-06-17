package r2s.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r2s.com.models.Department;
import r2s.com.reponsitory.DepartmentReponsitory;

@Service
public class DepartmentServiceImp implements DepartmentService{

	@Autowired
	private DepartmentReponsitory departmentReponsitory;
	
	@Override
	public Optional<Department> findById(String id) {
		return departmentReponsitory.findById(id);
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentReponsitory.findAll();
	}
	
}
