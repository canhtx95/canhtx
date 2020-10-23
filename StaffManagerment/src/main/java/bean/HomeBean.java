package bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("home")
@SessionScoped
public class HomeBean implements Serializable {
	
	@Inject
	public void testInject() {
		System.out.println("Inject");
	}
	@PostConstruct
	public void test() {
		System.out.println("test Postconstruct");
	}
	
	private static final long serialVersionUID = 1400302277070897159L;
	private int controlNumber =0 ;
	
	public int getControlNumber() {
		return controlNumber;
	}
	public void setControlNumber(int controlNumber) {
		this.controlNumber = controlNumber;
	}
	
}
