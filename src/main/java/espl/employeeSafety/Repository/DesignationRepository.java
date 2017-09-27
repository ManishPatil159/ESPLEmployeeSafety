package espl.employeeSafety.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import espl.employeeSafety.Entity.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer> {

}
