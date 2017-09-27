package espl.employeeSafety.Service;

import java.util.List;

import espl.employeeSafety.Entity.User;

public interface UserService {

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.UserService#getAllUsers()
	 */
	public abstract List<User> getAllUsers();

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.UserService#getUserById(int)
	 */
	public abstract User getUserById(int id);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.UserService#addUser(espl.employeeSafety.Entity.User)
	 */
	public abstract User addUser(User user);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.UserService#updateUser(int, espl.employeeSafety.Entity.User)
	 */
	public abstract User updateUser(int id, User user);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.UserService#deleteUser(int)
	 */
	public abstract void deleteUser(int id);

}