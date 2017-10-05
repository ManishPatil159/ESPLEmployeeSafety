package espl.employeeSafety.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import espl.employeeSafety.Entity.Designation;
import espl.employeeSafety.Entity.Project;

public interface DesignationService {

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.DesignationService#getAllDesignations()
	 */
	public abstract Page<Designation> getAllDesignations(Pageable pageable);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.DesignationService#getDesignationById(int)
	 */
	public abstract Designation getDesignationById(int id);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.DesignationService#addDesignation(espl.employeeSafety.Entity.Designation)
	 */
	public abstract Designation addDesignation(Designation Designation);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.DesignationService#updateDesignation(int, espl.employeeSafety.Entity.Designation)
	 */
	public abstract Designation updateDesignation(int id,
			Designation Designation);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.DesignationService#deleteDesignation(int)
	 */
	public abstract void deleteDesignation(int id);
	
	public abstract List<Designation> searchDesignationName(String searchTerm);

}