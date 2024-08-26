package com.reserva_facil.notificationService.domain.repository;

import com.reserva_facil.notificationService.domain.model.Notification;
import com.reserva_facil.notificationService.domain.model.NotificationChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {

    // Buscar notificações por destinatário
    List<Notification> findByRecipient(String recipient);

    // Buscar notificações por canal
    List<Notification> findByChannel(NotificationChannel channel);

    // Buscar notificações por status
    List<Notification> findBySuccess(Boolean success);

    // Buscar notificações enviadas dentro de um intervalo de datas
    List<Notification> findBySentAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Buscar notificações por status e canal
    List<Notification> findBySuccessAndChannel(Boolean success, NotificationChannel channel);
}
