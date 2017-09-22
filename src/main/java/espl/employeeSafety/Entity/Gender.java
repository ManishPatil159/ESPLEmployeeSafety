package espl.employeeSafety.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gender {

	public Gender() {
	}

	public Gender(String shortForm, String value) {
		this.shortForm = shortForm;
		Value = value;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String shortForm;
	private String Value;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortForm() {
		return shortForm;
	}

	public void setShortForm(String shortForm) {
		this.shortForm = shortForm;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}


}
