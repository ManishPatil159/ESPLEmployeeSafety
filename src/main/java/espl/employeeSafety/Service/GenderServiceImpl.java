package espl.employeeSafety.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import espl.employeeSafety.Entity.Gender;
import espl.employeeSafety.Repository.GenderRepository;

@Service
public class GenderServiceImpl implements GenderService {
	@Autowired
	private GenderRepository genderRepository;

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.GenderService#getAllGenders()
	 */
	@Override
	public List<Gender> getAllGenders(){
		return genderRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.GenderService#getGenderById(int)
	 */
	@Override
	public Gender getGenderById(int id) {
		return genderRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.GenderService#addGender(espl.employeeSafety.Entity.Gender)
	 */
	@Override
	public Gender addGender(Gender gender) {
		return genderRepository.save(gender);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.GenderService#updateGender(int, espl.employeeSafety.Entity.Gender)
	 */
	@Override
	public Gender updateGender(int id, Gender gender) {
		Gender repoGender=getGenderById(id);
		if(repoGender!=null) {
			repoGender.setShortForm(gender.getShortForm());
			repoGender.setValue(gender.getValue());
			return genderRepository.save(repoGender);	
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.GenderService#deleteGender(int)
	 */
	@Override
	public void deleteGender(int id) {
		genderRepository.delete(id);
	}
}
