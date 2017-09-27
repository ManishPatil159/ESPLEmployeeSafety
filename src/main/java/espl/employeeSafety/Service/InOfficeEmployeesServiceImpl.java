package espl.employeeSafety.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import espl.employeeSafety.Entity.InOfficeEmployees;
import espl.employeeSafety.Repository.InOfficeEmployeesRepository;

@Service
public class InOfficeEmployeesServiceImpl implements InOfficeEmployeesService {
	@Autowired
	private InOfficeEmployeesRepository InOfficeEmployeesRepository;

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.InOfficeEmployeesService#getAllInOfficeEmployeess()
	 */
	@Override
	public List<InOfficeEmployees> getAllInOfficeEmployeess(){
		return InOfficeEmployeesRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.InOfficeEmployeesService#getInOfficeEmployeesById(int)
	 */
	@Override
	public InOfficeEmployees getInOfficeEmployeesById(int id) {
		return InOfficeEmployeesRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.InOfficeEmployeesService#addInOfficeEmployees(espl.employeeSafety.Entity.InOfficeEmployees)
	 */
	@Override
	public InOfficeEmployees addInOfficeEmployees(InOfficeEmployees InOfficeEmployees) {
		return InOfficeEmployeesRepository.save(InOfficeEmployees);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.InOfficeEmployeesService#updateInOfficeEmployees(int, espl.employeeSafety.Entity.InOfficeEmployees)
	 */
	@Override
	public InOfficeEmployees updateInOfficeEmployees(int id, InOfficeEmployees InOfficeEmployees) {
		InOfficeEmployees repoInOfficeEmployees=getInOfficeEmployeesById(id);
		if(repoInOfficeEmployees!=null) {
			repoInOfficeEmployees.setInOfficeNotifiedTime(InOfficeEmployees.getInOfficeNotifiedTime());
			repoInOfficeEmployees.setOutTime(InOfficeEmployees.getOutTime());
			repoInOfficeEmployees.setTravelling(InOfficeEmployees.isTravelling());
			repoInOfficeEmployees.setReached(InOfficeEmployees.isReached());
			repoInOfficeEmployees.setReasonForWaiting(InOfficeEmployees.getReasonForWaiting());
			repoInOfficeEmployees.setcreatedDate(InOfficeEmployees.getcreatedDate());
			repoInOfficeEmployees.setEmployee(InOfficeEmployees.getEmployee());
			repoInOfficeEmployees.setProject(InOfficeEmployees.getProject());
			
			return InOfficeEmployeesRepository.save(repoInOfficeEmployees);	
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.InOfficeEmployeesService#deleteInOfficeEmployees(int)
	 */
	@Override
	public void deleteInOfficeEmployees(int id) {
		InOfficeEmployeesRepository.delete(id);
	}
}
