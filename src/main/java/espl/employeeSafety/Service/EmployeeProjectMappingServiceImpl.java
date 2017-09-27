package espl.employeeSafety.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import espl.employeeSafety.Entity.EmployeeProjectMapping;
import espl.employeeSafety.Repository.EmployeeProjectMappingRepository;

@Service
public class EmployeeProjectMappingServiceImpl implements EmployeeProjectMappingService{
	@Autowired
	private EmployeeProjectMappingRepository employeeRepository;

	
	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeProjectMappingService#getAllEmployeeProjectMappings()
	 */
	@Override
	public List<EmployeeProjectMapping> getAllEmployeeProjectMappings(){
		return employeeRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeProjectMappingService#getEmployeeProjectMappingById(int)
	 */
	@Override
	public EmployeeProjectMapping getEmployeeProjectMappingById(int id) {
		return employeeRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeProjectMappingService#addEmployeeProjectMapping(espl.employeeSafety.Entity.EmployeeProjectMapping)
	 */
	@Override
	public EmployeeProjectMapping addEmployeeProjectMapping(EmployeeProjectMapping employee) {
		return employeeRepository.save(employee);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeProjectMappingService#updateEmployeeProjectMapping(int, espl.employeeSafety.Entity.EmployeeProjectMapping)
	 */
	@Override
	public EmployeeProjectMapping updateEmployeeProjectMapping(int id, EmployeeProjectMapping employee) {
		EmployeeProjectMapping repoEmployeeProjectMapping=getEmployeeProjectMappingById(id);
		if(repoEmployeeProjectMapping!=null) {
			repoEmployeeProjectMapping.setEmployee(employee.getEmployee());
			repoEmployeeProjectMapping.setProject(employee.getProject());
			repoEmployeeProjectMapping.setDesignation(employee.getDesignation());
			return employeeRepository.save(repoEmployeeProjectMapping);	
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeProjectMappingService#deleteEmployeeProjectMapping(int)
	 */
	@Override
	public void deleteEmployeeProjectMapping(int id) {
		employeeRepository.delete(id);
	}
}
