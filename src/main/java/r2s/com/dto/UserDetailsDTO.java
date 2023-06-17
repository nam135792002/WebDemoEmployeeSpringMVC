package r2s.com.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import r2s.com.models.useCase;

public class UserDetailsDTO implements UserDetails{
	
	private useCase usecase;
	
	// contructor
	public UserDetailsDTO(useCase usecase) {
		this.usecase = usecase;
	}

	public useCase getUsecase() {
		return usecase;
	}

	public void setUsecase(useCase usecase) {
		this.usecase = usecase;
	}
	
	public useCase getUser() {
		return usecase;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return usecase.getListRole().stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getRoleName()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usecase.getPassWord();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usecase.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
