package espl.employeeSafety.Service;

import java.util.List;

import espl.employeeSafety.Entity.Notification;

public interface NotificationService {

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.NotificationService#getAllNotifications()
	 */
	public abstract List<Notification> getAllNotifications();

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.NotificationService#getNotificationById(int)
	 */
	public abstract Notification getNotificationById(int id);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.NotificationService#addNotification(espl.employeeSafety.Entity.Notification)
	 */
	public abstract Notification addNotification(Notification notification);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.NotificationService#updateNotification(int, espl.employeeSafety.Entity.Notification)
	 */
	public abstract Notification updateNotification(int id,
			Notification notification);

	/* (non-Javadoc)
	 * @see espl.employeeSafety.Service.NotificationService#deleteNotification(int)
	 */
	public abstract void deleteNotification(int id);

}