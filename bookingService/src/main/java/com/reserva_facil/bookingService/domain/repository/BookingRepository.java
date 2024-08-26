package com.reserva_facil.bookingService.domain.repository;

import com.reserva_facil.bookingService.domain.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
}
