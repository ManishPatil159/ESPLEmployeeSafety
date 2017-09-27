package espl.employeeSafety.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import espl.employeeSafety.Entity.Sos;

@Repository
public interface SosRepository extends JpaRepository<Sos, Integer>{

}
