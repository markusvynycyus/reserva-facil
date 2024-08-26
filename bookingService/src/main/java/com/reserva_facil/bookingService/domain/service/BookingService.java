package com.reserva_facil.bookingService.domain.service;

import com.reserva_facil.bookingService.domain.exception.RoomNotEncontradoException;
import com.reserva_facil.bookingService.domain.model.Booking;
import com.reserva_facil.bookingService.domain.repository.BookingRepository;
import com.reserva_facil.hotelService.domain.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelServiceClient hotelServiceClient;

    public Booking createBooking(Booking booking) throws RoomNotEncontradoException {
        Room room = hotelServiceClient.getRoomById(booking.getRoom().getId());
        if (room == null) {
            throw new RoomNotEncontradoException(booking.getRoom().getId());
        }
        booking.setRoom(room);
        return bookingRepository.save(booking);
    }
}
