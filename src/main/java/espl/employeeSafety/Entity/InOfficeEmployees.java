package espl.employeeSafety.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class InOfficeEmployees {
	
	public InOfficeEmployees() {

	}
	
	public InOfficeEmployees(Date notifiedTime, Date outTime, boolean isTravelling, boolean reached,
			String reasonForWaiting, Date currentDate, Employee employee, Project project) {
		this.inOfficeNotifiedTime = notifiedTime;
		this.outTime = outTime;
		this.isTravelling = isTravelling;
		this.reached = reached;
		this.reasonForWaiting = reasonForWaiting;
		this.createdDate = currentDate;
		this.employee = employee;
		this.project = project;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date inOfficeNotifiedTime;
	private Date outTime;
	private boolean isTravelling;
	private boolean reached;
	private String reasonForWaiting;
	private Date createdDate;
	@OneToOne
	private Employee employee;
	@OneToOne
	private Project project;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getInOfficeNotifiedTime() {
		return inOfficeNotifiedTime;
	}

	public void setInOfficeNotifiedTime(Date notifiedTime) {
		this.inOfficeNotifiedTime = notifiedTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public boolean isTravelling() {
		return isTravelling;
	}

	public void setTravelling(boolean isTravelling) {
		this.isTravelling = isTravelling;
	}

	public boolean isReached() {
		return reached;
	}

	public void setReached(boolean reached) {
		this.reached = reached;
	}

	public String getReasonForWaiting() {
		return reasonForWaiting;
	}

	public void setReasonForWaiting(String reasonForWaiting) {
		this.reasonForWaiting = reasonForWaiting;
	}

	public Date getcreatedDate() {
		return createdDate;
	}

	public void setcreatedDate(Date currentDate) {
		this.createdDate = currentDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	
}
