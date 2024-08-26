package com.reserva_facil.notificationService.domain.model;

public enum NotificationStatus {
    PENDING,   // Notificação pendente de envio
    SENT,      // Notificação enviada com sucesso
    FAILED     // Falha ao enviar a notificação
}