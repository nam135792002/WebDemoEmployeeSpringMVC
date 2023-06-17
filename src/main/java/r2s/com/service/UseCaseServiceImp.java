package r2s.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r2s.com.models.useCase;
import r2s.com.reponsitory.UseCaseReponsitory;

@Service
public class UseCaseServiceImp implements UseCaseService{

	@Autowired
	private UseCaseReponsitory usecaseReponsitory;

	@Override
	public useCase save(useCase usecase) {
		// TODO Auto-generated method stub
		return usecaseReponsitory.save(usecase);
	}

	@Override
	public List<useCase> findUseCaseByUserNameAndPassword(String userName, String passWord) {
		// TODO Auto-generated method stub
		return usecaseReponsitory.findUseCaseByUserNameAndPassword(userName, passWord);
	}

	@Override
	public List<useCase> findUseCaseByEmail(String email) {
		// TODO Auto-generated method stub
		return usecaseReponsitory.findUseCaseByEmail(email);
	}

	@Override
	public List<useCase> findUseCaseByUserName(String userName) {
		// TODO Auto-generated method stub
		return usecaseReponsitory.findUseCaseByUserName(userName);
	}
	
	
}
