package espl.employeeSafety.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import espl.employeeSafety.Entity.Sos;
import espl.employeeSafety.Repository.SosRepository;

@Service
public class SosServiceImpl implements SosService{
	@Autowired
	private SosRepository sosRepository;

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.SosService#getAllSoss()
	 */
	@Override
	public List<Sos> getAllSoss(){
		return sosRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.SosService#getSosById(int)
	 */
	@Override
	public Sos getSosById(int id) {
		return sosRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.SosService#addSos(espl.employeeSafety.Entity.Sos)
	 */
	@Override
	public Sos addSos(Sos sos) {
		return sosRepository.save(sos);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.SosService#updateSos(int, espl.employeeSafety.Entity.Sos)
	 */
	@Override
	public Sos updateSos(int id, Sos sos) {
		Sos repoSos=getSosById(id);
		if(repoSos!=null) {
			repoSos.setEmployee(sos.getEmployee());
			repoSos.setSosTime(sos.getSosTime());
			repoSos.setLattitude(sos.getLattitude());
			repoSos.setLongitude(sos.getLongitude());
			repoSos.setInOfficeEmployees(sos.getInOfficeEmployees());
			return sosRepository.save(repoSos);	
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.SosService#deleteSos(int)
	 */
	@Override
	public void deleteSos(int id) {
		sosRepository.delete(id);
	}
}
