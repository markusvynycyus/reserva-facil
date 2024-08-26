package com.reserva_facil.bookingService.domain.repository;

import com.reserva_facil.bookingService.domain.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {
}
