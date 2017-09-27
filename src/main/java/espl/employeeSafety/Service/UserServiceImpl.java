package espl.employeeSafety.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import espl.employeeSafety.Entity.User;
import espl.employeeSafety.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.UserService#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.UserService#getUserById(int)
	 */
	@Override
	public User getUserById(int id) {
		return userRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.UserService#addUser(espl.employeeSafety.Entity.User)
	 */
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.UserService#updateUser(int, espl.employeeSafety.Entity.User)
	 */
	@Override
	public User updateUser(int id, User user) {
		User repoUser=getUserById(id);
		if(repoUser!=null) {
			repoUser.setUsername(user.getUsername());
			repoUser.setPassword(user.getPassword());
			return userRepository.save(repoUser);	
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.UserService#deleteUser(int)
	 */
	@Override
	public void deleteUser(int id) {
		userRepository.delete(id);
	}
}
