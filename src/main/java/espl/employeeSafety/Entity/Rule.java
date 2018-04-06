package espl.employeeSafety.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rule {
	
	public Rule() {
	}
	
	public Rule(String rule, boolean needValues) {
		this.rule = rule;
		this.needValues = needValues;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String rule;
	private  boolean needValues;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public boolean isNeedValues() {
		return needValues;
	}

	public void setNeedValues(boolean needValues) {
		this.needValues = needValues;
	}
	
	
}
