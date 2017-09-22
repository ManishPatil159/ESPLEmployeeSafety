package espl.employeeSafety.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Sos {

	public Sos() {

	}
	
	public Sos(Employee employee, Date sosTime, String lattitude, String longitude,
			InOfficeEmployees inOfficeEmployees) {
		this.employee = employee;
		this.sosTime = sosTime;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.inOfficeEmployees = inOfficeEmployees;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Employee employee;
	private Date sosTime;
	private String lattitude;
	private String longitude;
	@OneToOne
	private InOfficeEmployees inOfficeEmployees;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getSosTime() {
		return sosTime;
	}

	public void setSosTime(Date sosTime) {
		this.sosTime = sosTime;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public InOfficeEmployees getInOfficeEmployees() {
		return inOfficeEmployees;
	}

	public void setInOfficeEmployees(InOfficeEmployees inOfficeEmployees) {
		this.inOfficeEmployees = inOfficeEmployees;
	}  

	
}
