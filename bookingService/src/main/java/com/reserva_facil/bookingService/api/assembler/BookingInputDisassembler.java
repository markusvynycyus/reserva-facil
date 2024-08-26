package com.reserva_facil.bookingService.api.assembler;

import com.reserva_facil.bookingService.domain.model.Booking;
import com.reserva_facil.bookingService.domain.model.Guest;
import com.reserva_facil.bookingService.domain.model.input.BookingInput;
import com.reserva_facil.bookingService.domain.model.input.GuestInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Booking toDomainObject(BookingInput bookingInput ) {

        return modelMapper.map(bookingInput, Booking.class);
    }

    public void copyToDomainObject(Long bookingInput, Booking booking) {
        modelMapper.map(bookingInput, booking);
    }
}
