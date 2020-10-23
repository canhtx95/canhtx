package services;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import connector.JdbcConnector;
import model.Department;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SessionScoped
public class ManageDepartment implements Serializable {

	private static final long serialVersionUID = 1L;
	private Department departmentFunction;
	private List<Department> listDepartment;
	private String outputFormat ;
	@Inject
	
	private JdbcConnector jdbc;
	@PostConstruct
	public void listOfDepartment() {
		listDepartment = new ArrayList<>();
		Statement st;
		try {
			st = jdbc.connect().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM department");
			while (rs.next()) {
				listDepartment.add(new Department(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getInt(6)));
			}
			rs.close();
			st.close();
			jdbc.connect().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Department> getListDepartment() {
		return listDepartment;
	}

	public void setListDepartment(List<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}

	public void addButton() {
		departmentFunction = new Department();
		departmentFunction.setNameDepartment("empty");
		String sql = "INSERT INTO department(name) VALUES(?) ";
		try {
			PreparedStatement ps = jdbc.connect().prepareStatement(sql);
			ps.setString(1, departmentFunction.getNameDepartment());
			ps.executeUpdate();
			ps.close();
			jdbc.connect().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setOutputFormat("ADD DEPARTMENT INFORMATION");
	}

	public void addOneDepartment() {
		Statement st;

		try {
			st = jdbc.connect().createStatement();
			ResultSet rs = st.executeQuery("SELECT id FROM department WHERE name = 'empty' ");
			while (rs.next()) {
				int id = rs.getInt(1);
				departmentFunction.setIdDepartment(id);
			}

			String sql = "UPDATE  department SET name=? ,cod=?,email=?, phone=? WHERE id=? ";
			PreparedStatement ps = jdbc.connect().prepareStatement(sql);
			ps.setString(1, departmentFunction.getNameDepartment());
			ps.setString(2, departmentFunction.getNameCod());
			ps.setString(3, departmentFunction.getEmail());
			ps.setInt(4, departmentFunction.getPhone());
			ps.setInt(5, departmentFunction.getIdDepartment());
			ps.executeUpdate();

			rs.close();
			st.close();
			jdbc.connect().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void backButton() {
		listDepartment = new ArrayList<>();
		Statement st;
		try {
			st = jdbc.connect().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM department");
			while (rs.next()) {
				listDepartment.add(new Department(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getInt(6)));
			}
			rs.close();
			st.close();
			jdbc.connect().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setDepartmentFunction(null);
	}

	public void updateDepartment(int x) {
		setOutputFormat("UPDATE DEPARTMENT INFORMATION");
		for (int i = 0; i < listDepartment.size(); i++) {
			if(listDepartment.get(i).getIdDepartment()==x) {
				departmentFunction = listDepartment.get(i);
				break;
			}
		}
		String sql = "UPDATE department SET id=? ,name =? ,cod=?, email=? ,phone=? WHERE id =?";
		try {
			PreparedStatement ps = jdbc.connect().prepareStatement(sql);
			ps.setInt(1, departmentFunction.getIdDepartment());
			ps.setString(2, departmentFunction.getNameDepartment());
			ps.setString(3, departmentFunction.getNameCod());
			ps.setString(4, departmentFunction.getEmail());
			ps.setInt(5, departmentFunction.getPhone());
			ps.setInt(6, departmentFunction.getIdDepartment());
			ps.executeUpdate();
			ps.close();
			jdbc.connect().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void deleteDepartment(int id) {
		String sql = " DELETE FROM department WHERE id = ?";
		try {
			PreparedStatement ps = jdbc.connect().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			ps.close();
			jdbc.connect().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < listDepartment.size(); i++) {
			if (id == listDepartment.get(i).getIdDepartment()) {
				listDepartment.remove(i);
			}
		}

	}

	public void getCurrentDepartment(int id) {
		for (int i = 0; i < listDepartment.size(); i++) {
			if (id == listDepartment.get(i).getIdDepartment()) {
				departmentFunction = listDepartment.get(i);
			}
		}
	}

	public Department getDepartmentFunction() {
		return departmentFunction;
	}

	public void setDepartmentFunction(Department departmentFunction) {
		this.departmentFunction = departmentFunction;
	}

	public String getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

}
