package espl.employeeSafety.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import espl.employeeSafety.Entity.Notification;
import espl.employeeSafety.Repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService{
	@Autowired
	private NotificationRepository notificationRepository;

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.NotificationService#getAllNotifications()
	 */
	@Override
	public List<Notification> getAllNotifications(){
		return notificationRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.NotificationService#getNotificationById(int)
	 */
	@Override
	public Notification getNotificationById(int id) {
		return notificationRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.NotificationService#addNotification(espl.employeeSafety.Entity.Notification)
	 */
	@Override
	public Notification addNotification(Notification notification) {
		return notificationRepository.save(notification);
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.NotificationService#updateNotification(int, espl.employeeSafety.Entity.Notification)
	 */
	@Override
	public Notification updateNotification(int id, Notification notification) {
		Notification repoNotification=getNotificationById(id);
		if(repoNotification!=null) {
			repoNotification.setDesignation(notification.getDesignation());
			return notificationRepository.save(repoNotification);	
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.NotificationService#deleteNotification(int)
	 */
	@Override
	public void deleteNotification(int id) {
		notificationRepository.delete(id);
	}
}
