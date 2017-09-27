package espl.employeeSafety.Service;

import java.util.List;

import espl.employeeSafety.Entity.InOfficeEmployees;

public interface InOfficeEmployeesService {

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.InOfficeEmployeesService#getAllInOfficeEmployeess()
	 */
	public abstract List<InOfficeEmployees> getAllInOfficeEmployeess();

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.InOfficeEmployeesService#getInOfficeEmployeesById(int)
	 */
	public abstract InOfficeEmployees getInOfficeEmployeesById(int id);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.InOfficeEmployeesService#addInOfficeEmployees(espl.employeeSafety.Entity.InOfficeEmployees)
	 */
	public abstract InOfficeEmployees addInOfficeEmployees(
			InOfficeEmployees InOfficeEmployees);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.InOfficeEmployeesService#updateInOfficeEmployees(int, espl.employeeSafety.Entity.InOfficeEmployees)
	 */
	public abstract InOfficeEmployees updateInOfficeEmployees(int id,
			InOfficeEmployees InOfficeEmployees);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.InOfficeEmployeesService#deleteInOfficeEmployees(int)
	 */
	public abstract void deleteInOfficeEmployees(int id);

}