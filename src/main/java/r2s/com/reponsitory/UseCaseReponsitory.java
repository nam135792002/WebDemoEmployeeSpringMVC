package r2s.com.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import r2s.com.models.useCase;

@Repository
public interface UseCaseReponsitory extends JpaRepository<useCase, Integer>{
	
	@Query(value = "SELECT uc FROM useCase uc WHERE uc.userName = :userName AND uc.passWord = :passWord")
	public List<useCase> findUseCaseByUserNameAndPassword(@Param("userName") String userName, @Param("passWord") String passWord);
	
	@Query(value = "SELECT uc FROM useCase uc WHERE uc.email = :email")
	public List<useCase> findUseCaseByEmail(@Param("email") String email);
	
	@Query(value = "SELECT uc FROM useCase uc WHERE uc.userName = :userName")
	public List<useCase> findUseCaseByUserName(@Param("userName") String userName);
}
