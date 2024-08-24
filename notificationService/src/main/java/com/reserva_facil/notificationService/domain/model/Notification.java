package com.reserva_facil.notificationService.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @NotBlank
    @Column(nullable = false)
    private String channel;    // Canal de envio (e.g., EMAIL, SMS, PUSH)

    private LocalDateTime sentAt; // Data e hora do envio

    private Boolean success;   // Indica se o envio foi bem-sucedido

}
