package r2s.com.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UseCase")
public class useCase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer idUseCase;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "PASS_WORD")
	private String passWord;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="userId",referencedColumnName = "ID")
	List<Role> listRole;
	
	public Integer getIdUseCase() {
		return idUseCase;
	}
	public void setIdUseCase(Integer idUseCase) {
		this.idUseCase = idUseCase;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public List<Role> getListRole() {
		return listRole;
	}
	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}
	
	
}
