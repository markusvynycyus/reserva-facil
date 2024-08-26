package com.reserva_facil.bookingService.api.assembler;

import com.reserva_facil.bookingService.domain.model.Booking;
import com.reserva_facil.bookingService.domain.model.Guest;
import com.reserva_facil.bookingService.domain.model.dto.BookingDTO;
import com.reserva_facil.bookingService.domain.model.dto.GuestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class BookingModelAssembler {
    @Autowired
    private ModelMapper modelMaper;

    public BookingDTO toModel(Booking booking) {

        return modelMaper.map(booking, BookingDTO.class);
    }

    public List<BookingDTO> toCollectionModel(List<Booking> bookings) {
        return bookings.stream()
                .map(booking -> toModel(booking))
                .collect(Collectors.toList());
    }
}
