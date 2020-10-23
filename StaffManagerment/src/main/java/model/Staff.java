package model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name, address, department;
	private int id, age;

	public Staff(int id, String name, int age, String address, String department) {
		this(id, name);
		this.age = age;
		this.address = address;
		this.department = department;
	}

	public Staff(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Staff() {

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
