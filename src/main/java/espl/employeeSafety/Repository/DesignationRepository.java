package espl.employeeSafety.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import espl.employeeSafety.Entity.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer> {
	@Query(value = "SELECT t FROM Designation t WHERE " +
            "LOWER(t.name) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
	public List<Designation> searchDesignationName(@Param("searchTerm") String searchTerm);
}
