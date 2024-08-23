package com.reserva_facil.notificationService.domain.repository;

import com.reserva_facil.notificationService.domain.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
