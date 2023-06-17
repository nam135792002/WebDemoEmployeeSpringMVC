package r2s.com.service;

import java.util.List;

import r2s.com.models.useCase;

public interface UseCaseService {
	useCase save(useCase usecase);
	List<useCase> findUseCaseByUserNameAndPassword(String userName, String passWord);
	List<useCase> findUseCaseByEmail(String email);
	List<useCase> findUseCaseByUserName(String userName);
}
