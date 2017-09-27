package espl.employeeSafety.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import espl.employeeSafety.Entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>{

}
