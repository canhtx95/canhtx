package model;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idDepartment,quantity,phone ;
	private String nameDepartment, nameCod, email;
	
	
	
	
	public Department(int idDepartment, String nameDepartment) {
		super();
		this.idDepartment = idDepartment;
		this.nameDepartment = nameDepartment;
	}
	
	
	public Department(int idDepartment, String nameDepartment, String nameCod,  String email ,int phone, int quantity) { 
		super();
		this.idDepartment = idDepartment;
		this.quantity = quantity;
		this.phone = phone;
		this.nameDepartment = nameDepartment;
		this.nameCod = nameCod;
		this.email = email;
	}


	public Department() {
		// TODO Auto-generated constructor stub
	}


	public int getIdDepartment() {
		return idDepartment;
	}
	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getNameDepartment() {
		return nameDepartment;
	}
	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}
	public String getNameCod() {
		return nameCod;
	}
	public void setNameCod(String nameCod) {
		this.nameCod = nameCod;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
