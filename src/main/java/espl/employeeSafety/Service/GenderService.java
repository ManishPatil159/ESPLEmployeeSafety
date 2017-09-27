package espl.employeeSafety.Service;

import java.util.List;

import espl.employeeSafety.Entity.Gender;

public interface GenderService {

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.GenderService#getAllGenders()
	 */
	public abstract List<Gender> getAllGenders();

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.GenderService#getGenderById(int)
	 */
	public abstract Gender getGenderById(int id);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.GenderService#addGender(espl.employeeSafety.Entity.Gender)
	 */
	public abstract Gender addGender(Gender gender);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.GenderService#updateGender(int, espl.employeeSafety.Entity.Gender)
	 */
	public abstract Gender updateGender(int id, Gender gender);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.GenderService#deleteGender(int)
	 */
	public abstract void deleteGender(int id);

}