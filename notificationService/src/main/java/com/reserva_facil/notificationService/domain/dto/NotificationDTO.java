package com.reserva_facil.notificationService.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NotificationDTO {

    private Long id;
    private String recipient;
    private String message;
    private String channel;
    private LocalDateTime sentAt;
    private Boolean success;
}
