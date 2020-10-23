package bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Staff;
import services.ManageStaff;
import java.io.Serializable;
import java.util.List;

@Named("staffBean")
@SessionScoped
public class StaffBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Staff staffFunction;
	@Inject
	ManageStaff ms;

	public void creatSlotDataBase() {
		setStaffFunction(new Staff());
		ms.creatSlotDataBase(staffFunction);
	}

	public void addStaffTable() {
		ms.addStaffTable(staffFunction);
	}

	public void delete(int id) {
		ms.delete(id);
	}

	public void backStaffTable() {
		ms.backAndUpdateStaffTable(staffFunction);
		staffFunction=null;
	}

	public void updateInfo(int id) {
		staffFunction = new Staff();
		ms.updateInfo(staffFunction, id);
	}

	public List<Staff> list() {

		return ms.getList();
	}
	public Staff getStaffFunction() {
		return staffFunction;
	}

	public void setStaffFunction(Staff staffFunction) {
		this.staffFunction = staffFunction;
	}
	public String title() {
		return ms.getTitle();
	}

}