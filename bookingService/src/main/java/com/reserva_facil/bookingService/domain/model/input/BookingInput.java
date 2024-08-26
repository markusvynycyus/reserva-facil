package com.reserva_facil.bookingService.domain.model.input;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingInput {

    @NotNull
    @Positive
    private Long guestId;

    @NotNull
    @Positive
    private Long roomId;

    @NotNull
    @Future
    private LocalDateTime checkInDate;

    @NotNull
    @Future
    private LocalDateTime checkOutDate;

    @Size(max = 20)
    private String status;
}
