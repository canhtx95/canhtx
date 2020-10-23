package bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Department;
import services.ManageDepartment;
import java.io.Serializable;
import java.util.List;
@Named("departmentBean")
@SessionScoped
public class DepartmentBean implements Serializable {

	private static final long serialVersionUID = 1L;
@Inject
ManageDepartment md;	

public List<Department> listDepartment(){
	return md.getListDepartment();
}
public void addButton() {
	md.addButton();
}
public void addOneDepartment() {
	md.addOneDepartment();
}
public void backButton() {
	md.backButton();
}
public void updateDepartment(int x) {
	md.updateDepartment(x);
}
public void deleteDepartment(int id) {
	md.deleteDepartment(id);
}
public Department departmentFunction() {
	return md.getDepartmentFunction();
}
public String title() {
	return md.getOutputFormat();
}
}
