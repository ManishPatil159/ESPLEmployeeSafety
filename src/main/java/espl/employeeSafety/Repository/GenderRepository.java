package espl.employeeSafety.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import espl.employeeSafety.Entity.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer>{

}
