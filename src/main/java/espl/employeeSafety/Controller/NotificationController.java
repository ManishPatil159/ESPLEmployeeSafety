package espl.employeeSafety.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import espl.employeeSafety.Entity.Notification;
import espl.employeeSafety.Service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
	@Autowired
	private NotificationService notificationService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Notification>> getAllNotifications(){
		return new ResponseEntity<List<Notification>>(notificationService.getAllNotifications(),HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Notification> getNotificationById(@PathVariable("id") int id) {
		return new ResponseEntity<Notification>(notificationService.getNotificationById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteNotification(@PathVariable("id") int id) {
		notificationService.deleteNotification(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Notification> updateNotification(@PathVariable("id") int id, @RequestBody Notification notification) {
		notification.setId(id);
		return new ResponseEntity<Notification>(notificationService.updateNotification(id, notification), HttpStatus.OK); 
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertNotification(@RequestBody Notification notification) {
		notificationService.addNotification(notification);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
