package com.reserva_facil.bookingService.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetails extends JpaRepository<PaymentDetails,Long> {
}
