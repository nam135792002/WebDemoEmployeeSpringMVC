package r2s.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import r2s.com.dto.UserDetailsDTO;
import r2s.com.models.useCase;
import r2s.com.reponsitory.UseCaseReponsitory;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UseCaseReponsitory useCaseRoponsitory;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<useCase> usecase = useCaseRoponsitory.findUseCaseByUserName(username);
		if(usecase.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}
		return new UserDetailsDTO(usecase.get(0));
	}
	
}
