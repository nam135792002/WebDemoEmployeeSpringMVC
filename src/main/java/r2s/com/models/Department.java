package r2s.com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {
	@Id
	@Column(name = "ID")
	private String idDepartment;
	@Column(name = "NAME")
	private String nameDepartment;
	public String getIdDepartment() {
		return idDepartment;
	}
	public void setIdDepartment(String idDepartment) {
		this.idDepartment = idDepartment;
	}
	public String getNameDepartment() {
		return nameDepartment;
	}
	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}
}
