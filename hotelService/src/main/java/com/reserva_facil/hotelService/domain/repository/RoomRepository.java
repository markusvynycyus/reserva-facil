package com.reserva_facil.hotelService.domain.repository;

import com.reserva_facil.hotelService.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
