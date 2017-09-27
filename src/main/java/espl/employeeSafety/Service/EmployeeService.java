package espl.employeeSafety.Service;

import java.util.List;

import espl.employeeSafety.Entity.Employee;

public interface EmployeeService {

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeService#getAllEmployees()
	 */
	public abstract List<Employee> getAllEmployees();

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeService#getEmployeeById(int)
	 */
	public abstract Employee getEmployeeById(int id);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeService#addEmployee(espl.employeeSafety.Entity.Employee)
	 */
	public abstract Employee addEmployee(Employee employee);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeService#updateEmployee(int, espl.employeeSafety.Entity.Employee)
	 */
	public abstract Employee updateEmployee(int id, Employee employee);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeService#deleteEmployee(int)
	 */
	public abstract void deleteEmployee(int id);

}