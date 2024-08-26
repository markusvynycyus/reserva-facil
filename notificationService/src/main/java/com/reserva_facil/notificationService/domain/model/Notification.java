package com.reserva_facil.notificationService.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Notification {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String recipient;  // Destinatário da notificação (e.g., email, telefone)

    @NotBlank
    @Column(nullable = false)
    private String message;    // Conteúdo da notificação

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationChannel channel;    // Canal de envio (e.g., EMAIL, SMS, PUSH)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationStatus status; // Status da notificação (e.g., PENDING, SENT, FAILED

    private LocalDateTime sentAt; // Data e hora do envio

    private Boolean success;   // Indica se o envio foi bem-sucedido

}
