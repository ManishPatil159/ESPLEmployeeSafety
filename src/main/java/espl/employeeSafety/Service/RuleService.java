package espl.employeeSafety.Service;

import java.util.List;

import espl.employeeSafety.Entity.Rule;

public interface RuleService {

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleService#getAllRules()
	 */
	public abstract List<Rule> getAllRules();

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleService#getRuleById(int)
	 */
	public abstract Rule getRuleById(int id);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleService#addRule(espl.employeeSafety.Entity.Rule)
	 */
	public abstract Rule addRule(Rule rule);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleService#updateRule(int, espl.employeeSafety.Entity.Rule)
	 */
	public abstract Rule updateRule(int id, Rule rule);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleService#deleteRule(int)
	 */
	public abstract void deleteRule(int id);

}