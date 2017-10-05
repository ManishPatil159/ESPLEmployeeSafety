package espl.employeeSafety.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import espl.employeeSafety.Entity.Employee;
import espl.employeeSafety.Entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
	@Query(value = "SELECT t FROM Project t WHERE " +
            "LOWER(t.projectName) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
	public List<Project> searchProjectName(@Param("searchTerm") String searchTerm);
}
