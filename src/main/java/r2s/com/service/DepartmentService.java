package r2s.com.service;

import java.util.List;
import java.util.Optional;

import r2s.com.models.Department;

public interface DepartmentService {
	Optional<Department> findById(String id);
	List<Department> findAll();
}
