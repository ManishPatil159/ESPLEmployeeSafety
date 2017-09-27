package espl.employeeSafety.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import espl.employeeSafety.Entity.EmployeeProjectMapping;

@Repository
public interface EmployeeProjectMappingRepository extends JpaRepository<EmployeeProjectMapping, Integer>{

}
