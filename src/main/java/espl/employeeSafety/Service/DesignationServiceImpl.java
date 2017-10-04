package espl.employeeSafety.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import espl.employeeSafety.Entity.Designation;
import espl.employeeSafety.Repository.DesignationRepository;

@Service
public class DesignationServiceImpl implements DesignationService{
	@Autowired
	private DesignationRepository DesignationRepository;

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.DesignationService#getAllDesignations()
	 */
	@Override
	public Page<Designation> getAllDesignations(Pageable pageable){
		return DesignationRepository.findAll(pageable);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.DesignationService#getDesignationById(int)
	 */
	
	@Override
	public Designation getDesignationById(int id) {
		return DesignationRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.DesignationService#addDesignation(espl.employeeSafety.Entity.Designation)
	 */
	
	@Override
	public Designation addDesignation(Designation Designation) {
		return DesignationRepository.save(Designation);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.DesignationService#updateDesignation(int, espl.employeeSafety.Entity.Designation)
	 */
	
	@Override
	public Designation updateDesignation(int id, Designation Designation) {
		Designation repoDesignation=getDesignationById(id);
		if(repoDesignation!=null) {
			repoDesignation.setName(Designation.getName());
			return DesignationRepository.save(repoDesignation);	
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.DesignationService#deleteDesignation(int)
	 */
	
	@Override
	public void deleteDesignation(int id) {
		DesignationRepository.delete(id);
	}
}
