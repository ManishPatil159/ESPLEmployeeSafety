package espl.employeeSafety.Service;

import java.util.List;

import espl.employeeSafety.Entity.RuleMapping;

public interface RuleMappingService {

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleMappingService#getAllRuleMappings()
	 */
	public abstract List<RuleMapping> getAllRuleMappings();

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleMappingService#getRuleMappingById(int)
	 */
	public abstract RuleMapping getRuleMappingById(int id);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleMappingService#addRuleMapping(espl.employeeSafety.Entity.RuleMapping)
	 */
	public abstract RuleMapping addRuleMapping(RuleMapping ruleMapping);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleMappingService#updateRuleMapping(int, espl.employeeSafety.Entity.RuleMapping)
	 */
	public abstract RuleMapping updateRuleMapping(int id,
			RuleMapping ruleMapping);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleMappingService#deleteRuleMapping(int)
	 */
	public abstract void deleteRuleMapping(int id);

}