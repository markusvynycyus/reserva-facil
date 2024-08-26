package com.reserva_facil.bookingService.domain.service;

import com.reserva_facil.bookingService.domain.exception.BookingNaoEncontradoException;
import com.reserva_facil.bookingService.domain.exception.GuestNaoEncontradoException;
import com.reserva_facil.bookingService.domain.exception.RoomNotEncontradoException;
import com.reserva_facil.bookingService.domain.model.Booking;
import com.reserva_facil.bookingService.domain.model.Guest;
import com.reserva_facil.bookingService.domain.repository.BookingRepository;
import com.reserva_facil.hotelService.domain.exception.EntidadeEmUsoException;
import com.reserva_facil.hotelService.domain.exception.RoomNaoEncontradoException;
import com.reserva_facil.hotelService.domain.model.Room;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private static final String MSG_BOOKING_EM_USO
            = "Booking de código %d não pode ser removido, pois está em uso";


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

    @Transactional
    public void excluir(Long guestId) {
        try {
            bookingRepository.deleteById(guestId);
            bookingRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new BookingNaoEncontradoException(guestId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_BOOKING_EM_USO, guestId));
        }
    }

    public Booking buscarOuFalhar(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNaoEncontradoException(bookingId));
    }



}
