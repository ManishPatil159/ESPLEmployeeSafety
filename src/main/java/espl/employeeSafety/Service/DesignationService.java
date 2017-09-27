package espl.employeeSafety.Service;

import java.util.List;

import espl.employeeSafety.Entity.Designation;

public interface DesignationService {

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.DesignationService#getAllDesignations()
	 */
	public abstract List<Designation> getAllDesignations();

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

}