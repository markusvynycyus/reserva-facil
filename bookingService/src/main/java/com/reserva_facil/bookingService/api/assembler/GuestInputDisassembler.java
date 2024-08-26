package com.reserva_facil.bookingService.api.assembler;

import com.reserva_facil.bookingService.domain.model.Guest;
import com.reserva_facil.bookingService.domain.model.input.GuestInput;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuestInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Guest toDomainObject(GuestInput guestInput) {

        return modelMapper.map(guestInput, Guest.class);
    }

    public void copyToDomainObject(Long guestInput, Guest guest) {
        modelMapper.map(guestInput, guest);
    }
}
