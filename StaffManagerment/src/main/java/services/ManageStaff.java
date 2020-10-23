package services;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import connector.JdbcConnector;
import model.Staff;

@SessionScoped
public class ManageStaff implements Serializable {

	private static final long serialVersionUID = 7278678841707475562L;
	private List<Staff> list;
	private String title ;
	@Inject
	private JdbcConnector jdbc;
	
	
	@PostConstruct
	public void getStaffList() {
		list = new ArrayList<>();
		try {
			Statement st = jdbc.connect().createStatement();
			ResultSet rs = st.executeQuery("SELECT*FROM staff");

			while (rs.next()) {
				list.add(new Staff(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
			}
			rs.close();
			st.close();
			jdbc.connect().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		String sql = " DELETE FROM staff WHERE id = ?";
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
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				list.remove(i);
				
			}
		}
	}

	public void creatSlotDataBase(Staff staffFunction) {
		staffFunction.setName("No Name");
		String sql = "INSERT INTO staff(name) VALUES(?)";
		try {
			PreparedStatement ps = jdbc.connect().prepareStatement(sql);
			ps.setString(1, staffFunction.getName());
			ps.executeUpdate();
			ps.close();
			jdbc.connect().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setTitle("ADD STAFF INFORMATION");
	}

	public void getIdForStaffFunction(Staff staffFunction) {
		try {
			Statement st = jdbc.connect().createStatement();
			ResultSet rs = st.executeQuery("SELECT id FROM staff WHERE name = 'No Name' ");
			while (rs.next()) {
				staffFunction.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addStaffTable(Staff staffFunction) {
		getIdForStaffFunction(staffFunction);
		int id, age;
		String address, name, deparment;
		
		try {
			String sql = "UPDATE staff SET name=?,age=?,address=?, department=? WHERE id=? ";
			id = staffFunction.getId();
			name = staffFunction.getName();
			age = staffFunction.getAge();
			address = staffFunction.getAddress();
			deparment = staffFunction.getDepartment();
			PreparedStatement ps = jdbc.connect().prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, address);
			ps.setString(4, deparment);
			ps.setInt(5, id);
			ps.executeUpdate();
			ps.close();
			jdbc.connect().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void backAndUpdateStaffTable(Staff staffFunction) {
		list = new ArrayList<>();
		try {
			Statement st = jdbc.connect().createStatement();
			ResultSet rs = st.executeQuery("SELECT*FROM staff");

			while (rs.next()) {
				list.add(new Staff(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
			}
			rs.close();
			st.close();
			jdbc.connect().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void updateInfo(Staff staffFunction,int x) {
		setTitle("UPDATE STAFF INFORMATION");
		for(int i = 0 ; i< list.size();i++) {
			if(list.get(i).getId() == x) {
				staffFunction.setId(x);
				staffFunction.setName(list.get(i).getName());
				staffFunction.setAge(list.get(i).getAge());
				staffFunction.setAddress(list.get(i).getAddress());
				staffFunction.setDepartment(list.get(i).getDepartment());
				
//				staffFunction=list.get(i);
				break;
			}
		}
//		staffFunction.setName("update");
//		staffFunction.setAge(25);
		int id, age;
		String address, name, deparment;
		
		try {
			String sql = "UPDATE staff SET name=?,age=?,address=?, department=? WHERE id=? ";
			id = staffFunction.getId();
			name = staffFunction.getName();
			age = staffFunction.getAge();
			address = staffFunction.getAddress();
			deparment = staffFunction.getDepartment();
			PreparedStatement ps = jdbc.connect().prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, address);
			ps.setString(4, deparment);
			ps.setInt(5, id);
			ps.executeUpdate();
			ps.close();
			jdbc.connect().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public List<Staff> getList() {
		return list;
	}

	public void setList(List<Staff> list) {
		this.list = list;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}