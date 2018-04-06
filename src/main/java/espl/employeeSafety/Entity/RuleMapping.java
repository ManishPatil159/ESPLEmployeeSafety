package espl.employeeSafety.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class RuleMapping {
	
	public RuleMapping() {
		
	}
	
	public RuleMapping(String value, Rule ruleId, List<Project> project, List<Employee> employee) {
		this.value = value;
		this.ruleId = ruleId;
		this.project = project;
		this.employee = employee;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String value;
	@OneToOne
	private Rule ruleId;
	@OneToMany
	private List<Project> project;
	@OneToMany
	private List<Employee> employee;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Rule getRuleId() {
		return ruleId;
	}

	public void setRuleId(Rule ruleId) {
		this.ruleId = ruleId;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
}
