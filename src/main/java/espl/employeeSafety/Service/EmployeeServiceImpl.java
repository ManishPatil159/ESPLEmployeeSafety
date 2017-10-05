package espl.employeeSafety.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import espl.employeeSafety.Entity.Employee;
import espl.employeeSafety.Repository.EmployeeRepository;
//import espl.employeeSafety.Repository.EmployeeRepositoryCustom;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	/*@Autowired
	private EmployeeRepositoryCustom empCustom;*/
	
	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeService#getAllEmployees()
	 */
	@Override
	public Page<Employee> getAllEmployees(Pageable pageable){
		return employeeRepository.findAll(pageable);
	}
	
	public List<Employee> searchWithJPQLQuery(String searchTerm){
		return employeeRepository.searchWithJPQLQuery(searchTerm);
	}
	/*public List<Employee> findByfirstNameContainsOrlastNameContainsAllIgnoreCase(String firstName, String lastName){
		return empCustom.findByfirstNameContainsOrlastNameContainsAllIgnoreCase(firstName,lastName);
	}*/

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeService#getEmployeeById(int)
	 */
	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeService#addEmployee(espl.employeeSafety.Entity.Employee)
	 */
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeService#updateEmployee(int, espl.employeeSafety.Entity.Employee)
	 */
	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee repoEmployee=getEmployeeById(id);
		if(repoEmployee!=null) {
			repoEmployee.setFirstName(employee.getFirstName());
			repoEmployee.setLastName(employee.getLastName());
			repoEmployee.setEmployeeId(employee.getEmployeeId());
			repoEmployee.setDesignation(employee.getDesignation());
			repoEmployee.setPermanentAddress(employee.getPermanentAddress());
			repoEmployee.setCurrentAddress(employee.getCurrentAddress());
			repoEmployee.setContactNumber(employee.getContactNumber());
			repoEmployee.setEmergengyNumber1(employee.getEmergengyNumber1());
			repoEmployee.setEmergengyNumber2(employee.getEmergengyNumber2());
			repoEmployee.setGender(employee.getGender());
			repoEmployee.setUser(employee.getUser());
			return employeeRepository.save(repoEmployee);	
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.EmployeeService#deleteEmployee(int)
	 */
	@Override
	public void deleteEmployee(int id) {
		employeeRepository.delete(id);
	}
}
