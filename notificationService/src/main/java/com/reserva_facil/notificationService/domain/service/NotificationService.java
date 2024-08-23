package com.reserva_facil.notificationService.domain.service;

import com.reserva_facil.notificationService.domain.model.Notification;
import com.reserva_facil.notificationService.domain.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification salvar(Notification notification) {
        return notificationRepository.save(notification);
    }
}
