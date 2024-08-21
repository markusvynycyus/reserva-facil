package com.reserva_facil.hotelService.domain.repository;

import com.reserva_facil.hotelService.domain.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
