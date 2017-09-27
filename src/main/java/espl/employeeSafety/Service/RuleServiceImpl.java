package espl.employeeSafety.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import espl.employeeSafety.Entity.Rule;
import espl.employeeSafety.Repository.RuleRepository;

@Service
public class RuleServiceImpl implements RuleService {
	@Autowired
	private RuleRepository ruleRepository;

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleService#getAllRules()
	 */
	@Override
	public List<Rule> getAllRules(){
		return ruleRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleService#getRuleById(int)
	 */
	@Override
	public Rule getRuleById(int id) {
		return ruleRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleService#addRule(espl.employeeSafety.Entity.Rule)
	 */
	@Override
	public Rule addRule(Rule rule) {
		return ruleRepository.save(rule);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleService#updateRule(int, espl.employeeSafety.Entity.Rule)
	 */
	@Override
	public Rule updateRule(int id, Rule rule) {
		Rule repoRule=getRuleById(id);
		if(repoRule!=null) {
			repoRule.setRule(rule.getRule());
			repoRule.setNeedValues(rule.isNeedValues());
			return ruleRepository.save(repoRule);	
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleService#deleteRule(int)
	 */
	@Override
	public void deleteRule(int id) {
		ruleRepository.delete(id);
	}
}
