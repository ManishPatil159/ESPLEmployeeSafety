package espl.employeeSafety.Service;

import java.util.List;

import espl.employeeSafety.Entity.EmployeeProjectMapping;

public interface EmployeeProjectMappingService {

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeProjectMappingService#getAllEmployeeProjectMappings()
	 */
	public abstract List<EmployeeProjectMapping> getAllEmployeeProjectMappings();

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeProjectMappingService#getEmployeeProjectMappingById(int)
	 */
	public abstract EmployeeProjectMapping getEmployeeProjectMappingById(int id);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeProjectMappingService#addEmployeeProjectMapping(espl.employeeSafety.Entity.EmployeeProjectMapping)
	 */
	public abstract EmployeeProjectMapping addEmployeeProjectMapping(
			EmployeeProjectMapping employee);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeProjectMappingService#updateEmployeeProjectMapping(int, espl.employeeSafety.Entity.EmployeeProjectMapping)
	 */
	public abstract EmployeeProjectMapping updateEmployeeProjectMapping(int id,
			EmployeeProjectMapping employee);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeProjectMappingService#deleteEmployeeProjectMapping(int)
	 */
	public abstract void deleteEmployeeProjectMapping(int id);

}