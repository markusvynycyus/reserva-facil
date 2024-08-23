package com.reserva_facil.notificationService.domain.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationInput {

    @NotBlank
    private String recipient;

    @NotBlank
    private String message;

}
