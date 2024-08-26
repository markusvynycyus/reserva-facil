package com.reserva_facil.bookingService.domain.model.dto;

import com.reserva_facil.bookingService.domain.model.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingDTO {

    private Long id;

    private Long roomId; // ID do quarto, se necessário

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    private BookingStatus status;
}
