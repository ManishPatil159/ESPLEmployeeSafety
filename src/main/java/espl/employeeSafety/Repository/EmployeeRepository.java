package espl.employeeSafety.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import espl.employeeSafety.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query("SELECT t FROM Employee t WHERE " +
            "LOWER(t.firstName) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.lastName) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    public List<Employee> searchWithJPQLQuery(@Param("searchTerm") String searchTerm);
}
