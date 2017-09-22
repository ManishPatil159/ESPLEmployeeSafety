package espl.employeeSafety.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	public Employee() {

	}
	
	public Employee(String firstName, String lastName, String employeeId, Designation designation,
			String permanentAddress, String currentAddress, String contactNumber, String emergengyNumber1,
			String emergengyNumber2, Gender gender, User user) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.designation = designation;
		this.permanentAddress = permanentAddress;
		this.currentAddress = currentAddress;
		this.contactNumber = contactNumber;
		this.emergengyNumber1 = emergengyNumber1;
		this.emergengyNumber2 = emergengyNumber2;
		this.gender = gender;
		this.user = user;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String employeeId;
	private String  permanentAddress;
	private String currentAddress;
	private String contactNumber;
	private String emergengyNumber1;
	private String emergengyNumber2;
	@ManyToOne
	private Designation designation;
	@ManyToOne
	private Gender gender;
	@OneToOne
	private User user;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmergengyNumber1() {
		return emergengyNumber1;
	}

	public void setEmergengyNumber1(String emergengyNumber1) {
		this.emergengyNumber1 = emergengyNumber1;
	}

	public String getEmergengyNumber2() {
		return emergengyNumber2;
	}

	public void setEmergengyNumber2(String emergengyNumber2) {
		this.emergengyNumber2 = emergengyNumber2;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
