package com.reserva_facil.bookingService.domain.model;

public enum BookingStatus {

    PENDING,    // Reserva criada, aguardando confirmação
    CONFIRMED,  // Reserva confirmada, pagamento realizado
    CANCELLED,  // Reserva cancelada pelo hóspede ou pelo sistema
    CHECKED_IN, // Hóspede realizou o check-in no hotel
    CHECKED_OUT // Hóspede realizou o check-out no hotel
}
