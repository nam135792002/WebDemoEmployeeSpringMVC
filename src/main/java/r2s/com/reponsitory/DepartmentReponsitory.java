package r2s.com.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import r2s.com.models.Department;

@Repository
public interface DepartmentReponsitory extends JpaRepository<Department, String>{

}
