package espl.employeeSafety.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import espl.employeeSafety.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
//	List<Employee> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);
}
