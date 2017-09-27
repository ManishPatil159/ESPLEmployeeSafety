package espl.employeeSafety.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import espl.employeeSafety.Entity.RuleMapping;

@Repository
public interface RuleMappingRepository extends JpaRepository<RuleMapping, Integer>{

}
