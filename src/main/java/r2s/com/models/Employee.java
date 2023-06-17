package r2s.com.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer idEmployee;
	@Column(name = "FULNAME")
	private String fullName;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "DATEOFBIRTH")
	private Date dateOfBirth;
	@ManyToOne
	@JoinColumn(name = "ID_DEPARTMENT",referencedColumnName = "ID")
	private Department department;
	
	public Employee() {
	
	}
	public Integer getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
