package espl.employeeSafety.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import espl.employeeSafety.Entity.RuleMapping;
import espl.employeeSafety.Repository.RuleMappingRepository;

@Service
public class RuleMappingServiceImpl implements RuleMappingService {
	@Autowired
	private RuleMappingRepository ruleMappingRepository;

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleMappingService#getAllRuleMappings()
	 */
	@Override
	public List<RuleMapping> getAllRuleMappings(){
		return ruleMappingRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleMappingService#getRuleMappingById(int)
	 */
	@Override
	public RuleMapping getRuleMappingById(int id) {
		return ruleMappingRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleMappingService#addRuleMapping(espl.employeeSafety.Entity.RuleMapping)
	 */
	@Override
	public RuleMapping addRuleMapping(RuleMapping ruleMapping) {
		return ruleMappingRepository.save(ruleMapping);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleMappingService#updateRuleMapping(int, espl.employeeSafety.Entity.RuleMapping)
	 */
	@Override
	public RuleMapping updateRuleMapping(int id, RuleMapping ruleMapping) {
		RuleMapping repoRuleMapping=getRuleMappingById(id);
		if(repoRuleMapping!=null) {
			repoRuleMapping.setValue(ruleMapping.getValue());
			repoRuleMapping.setRuleId(ruleMapping.getRuleId());
			repoRuleMapping.setProject(ruleMapping.getProject());
			repoRuleMapping.setEmployee(ruleMapping.getEmployee());
			return ruleMappingRepository.save(repoRuleMapping);	
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.RuleMappingService#deleteRuleMapping(int)
	 */
	@Override
	public void deleteRuleMapping(int id) {
		ruleMappingRepository.delete(id);
	}
}
