package com.reserva_facil.bookingService.domain.model;

import com.reserva_facil.hotelService.domain.model.Room;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Booking {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Guest guest;

    @ManyToOne
    private Room room;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

}
