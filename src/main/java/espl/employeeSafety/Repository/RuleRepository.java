package espl.employeeSafety.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import espl.employeeSafety.Entity.Rule;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Integer>{

}
